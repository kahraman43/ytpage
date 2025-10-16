# Component Documentation

## Overview

This document provides detailed documentation for all HTML components, elements, and their properties used in the project.

## Table of Contents

1. [HTML Document Structure](#html-document-structure)
2. [Head Components](#head-components)
3. [Body Components](#body-components)
4. [Component Reference](#component-reference)
5. [Extending Components](#extending-components)

---

## HTML Document Structure

### Document Component

**Element:** Root HTML Document

**Purpose:** Serves as the container for all HTML content

**Properties:**
- **Type:** HTML5 Document
- **Encoding:** UTF-8 (recommended)
- **Language:** Not specified (should add `lang="en"`)

**Structure:**
```html
<!DOCTYPE html>
<html>
    <head>...</head>
    <body>...</body>
</html>
```

**Best Practices:**
```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        ...
    </head>
    <body>
        ...
    </body>
</html>
```

---

## Head Components

### Title Component

**Element:** `<title>`

**Current Value:** "Example Page"

**Purpose:** Defines the document title shown in browser tab/window

**Properties:**
- **Required:** Yes
- **Multiple Allowed:** No
- **Character Limit:** ~60 characters recommended for SEO

**Usage:**
```html
<title>Example Page</title>
```

**Examples:**
```html
<!-- Good: Descriptive and concise -->
<title>Home - My Website</title>

<!-- Better: Includes branding and context -->
<title>Dashboard | MyApp - Project Management</title>

<!-- Best: Optimized for SEO -->
<title>Project Management Dashboard | MyApp - Organize Your Tasks</title>
```

**SEO Considerations:**
- Keep under 60 characters
- Include primary keyword
- Be descriptive and unique per page
- Include brand name

### Meta Components

Currently not implemented. Recommended meta components:

#### Charset Meta

**Purpose:** Declares character encoding

```html
<meta charset="UTF-8">
```

**Properties:**
- **Required:** Highly recommended
- **Position:** First element in `<head>`
- **Value:** UTF-8 (standard)

#### Viewport Meta

**Purpose:** Controls viewport behavior on mobile devices

```html
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

**Properties:**
- `width`: Viewport width (use `device-width`)
- `initial-scale`: Initial zoom level (1.0 = 100%)
- `maximum-scale`: Max zoom level (optional)
- `user-scalable`: Allow user zoom (optional)

**Examples:**
```html
<!-- Standard responsive -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Prevent zoom (accessibility concern) -->
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
```

#### Description Meta

**Purpose:** Provides page description for search engines

```html
<meta name="description" content="A comprehensive example page demonstrating HTML structure">
```

**Properties:**
- **Length:** 150-160 characters recommended
- **Content:** Descriptive, includes keywords
- **Unique:** Different for each page

---

## Body Components

### Heading Component (H1)

**Element:** `<h1>`

**Current Value:** "Hello World"

**Purpose:** Primary heading for the page content

**Properties:**
- **Semantic Level:** 1 (highest)
- **Default Styling:** Large, bold text
- **SEO Weight:** High importance
- **Accessibility:** Used by screen readers for navigation

**Usage:**
```html
<h1>Hello World</h1>
```

**Styling:**
```css
h1 {
    font-size: 2em;
    margin: 0.67em 0;
    font-weight: bold;
}
```

**Examples:**
```html
<!-- Basic -->
<h1>Hello World</h1>

<!-- With ID for linking -->
<h1 id="main-heading">Hello World</h1>

<!-- With classes for styling -->
<h1 class="page-title primary-heading">Hello World</h1>

<!-- With data attributes -->
<h1 data-component="main-heading" data-version="1.0">Hello World</h1>

<!-- With ARIA attributes -->
<h1 role="heading" aria-level="1" aria-label="Main page heading">Hello World</h1>
```

**Best Practices:**
- Use only ONE `<h1>` per page
- Should describe the main page content
- Keep concise and descriptive
- Avoid skipping heading levels (h1 → h3)

**Accessibility:**
```html
<!-- Good: Clear and descriptive -->
<h1>Welcome to Our Services</h1>

<!-- Better: Provides context -->
<h1>Our Services - Web Development and Design</h1>

<!-- Best: Screen reader optimized -->
<main>
    <h1 id="main-content" tabindex="-1">
        Our Services - Web Development and Design
    </h1>
</main>
```

---

## Component Reference

### Standard HTML Components (Available for Use)

#### Heading Components (h1-h6)

| Component | Purpose | Current Use | Semantic Level |
|-----------|---------|-------------|----------------|
| `<h1>` | Main page heading | ✅ Used | 1 (highest) |
| `<h2>` | Section headings | ❌ Not used | 2 |
| `<h3>` | Subsection headings | ❌ Not used | 3 |
| `<h4>` | Sub-subsection headings | ❌ Not used | 4 |
| `<h5>` | Minor headings | ❌ Not used | 5 |
| `<h6>` | Lowest level headings | ❌ Not used | 6 |

**Example Hierarchy:**
```html
<h1>Main Page Title</h1>
    <h2>Section 1</h2>
        <h3>Subsection 1.1</h3>
        <h3>Subsection 1.2</h3>
    <h2>Section 2</h2>
        <h3>Subsection 2.1</h3>
```

#### Text Components

| Component | Purpose | Example |
|-----------|---------|---------|
| `<p>` | Paragraph | `<p>Text content</p>` |
| `<span>` | Inline container | `<span class="highlight">Text</span>` |
| `<strong>` | Important text | `<strong>Important</strong>` |
| `<em>` | Emphasized text | `<em>Emphasized</em>` |
| `<small>` | Small text | `<small>Fine print</small>` |
| `<mark>` | Highlighted text | `<mark>Highlighted</mark>` |

#### List Components

**Unordered List:**
```html
<ul>
    <li>Item 1</li>
    <li>Item 2</li>
    <li>Item 3</li>
</ul>
```

**Ordered List:**
```html
<ol>
    <li>First step</li>
    <li>Second step</li>
    <li>Third step</li>
</ol>
```

**Description List:**
```html
<dl>
    <dt>Term 1</dt>
    <dd>Definition 1</dd>
    <dt>Term 2</dt>
    <dd>Definition 2</dd>
</dl>
```

#### Link Components

```html
<!-- Standard link -->
<a href="https://example.com">Link Text</a>

<!-- Link with target -->
<a href="https://example.com" target="_blank" rel="noopener noreferrer">External Link</a>

<!-- Email link -->
<a href="mailto:email@example.com">Email Us</a>

<!-- Phone link -->
<a href="tel:+1234567890">Call Us</a>

<!-- Anchor link -->
<a href="#section1">Jump to Section</a>
```

#### Media Components

**Images:**
```html
<!-- Basic image -->
<img src="image.jpg" alt="Description">

<!-- Responsive image -->
<img src="image.jpg" 
     alt="Description" 
     loading="lazy" 
     width="800" 
     height="600">

<!-- Picture element for responsive images -->
<picture>
    <source media="(min-width: 800px)" srcset="large.jpg">
    <source media="(min-width: 400px)" srcset="medium.jpg">
    <img src="small.jpg" alt="Description">
</picture>
```

**Audio:**
```html
<audio controls>
    <source src="audio.mp3" type="audio/mpeg">
    <source src="audio.ogg" type="audio/ogg">
    Your browser does not support audio.
</audio>
```

**Video:**
```html
<video controls width="640" height="360">
    <source src="video.mp4" type="video/mp4">
    <source src="video.webm" type="video/webm">
    Your browser does not support video.
</video>
```

#### Form Components

```html
<form action="/submit" method="POST">
    <!-- Text input -->
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>
    
    <!-- Email input -->
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>
    
    <!-- Textarea -->
    <label for="message">Message:</label>
    <textarea id="message" name="message" rows="4"></textarea>
    
    <!-- Select dropdown -->
    <label for="category">Category:</label>
    <select id="category" name="category">
        <option value="general">General</option>
        <option value="support">Support</option>
    </select>
    
    <!-- Radio buttons -->
    <fieldset>
        <legend>Choose option:</legend>
        <input type="radio" id="option1" name="option" value="1">
        <label for="option1">Option 1</label>
        
        <input type="radio" id="option2" name="option" value="2">
        <label for="option2">Option 2</label>
    </fieldset>
    
    <!-- Checkbox -->
    <input type="checkbox" id="agree" name="agree" required>
    <label for="agree">I agree to terms</label>
    
    <!-- Submit button -->
    <button type="submit">Submit</button>
</form>
```

#### Semantic Structure Components

```html
<!-- Header -->
<header>
    <nav>
        <ul>
            <li><a href="/">Home</a></li>
            <li><a href="/about">About</a></li>
        </ul>
    </nav>
</header>

<!-- Main content -->
<main>
    <article>
        <h1>Article Title</h1>
        <p>Article content...</p>
    </article>
    
    <aside>
        <h2>Related Content</h2>
        <p>Sidebar content...</p>
    </aside>
</main>

<!-- Footer -->
<footer>
    <p>&copy; 2025 Example</p>
</footer>
```

#### Container Components

```html
<!-- Generic containers -->
<div class="container">Block-level container</div>
<span class="inline">Inline container</span>

<!-- Semantic containers -->
<section>
    <h2>Section Title</h2>
    <p>Section content...</p>
</section>

<article>
    <h2>Article Title</h2>
    <p>Article content...</p>
</article>

<aside>
    <h2>Sidebar</h2>
    <p>Additional information...</p>
</aside>
```

---

## Extending Components

### Creating Custom Components

#### Method 1: Web Components (Custom Elements)

```html
<script>
class HelloWorld extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({ mode: 'open' });
    }
    
    connectedCallback() {
        this.shadowRoot.innerHTML = `
            <style>
                h1 { color: blue; }
            </style>
            <h1>Hello World Custom Component</h1>
        `;
    }
}

customElements.define('hello-world', HelloWorld);
</script>

<!-- Usage -->
<hello-world></hello-world>
```

#### Method 2: Template-based Components

```html
<template id="card-template">
    <style>
        .card {
            border: 1px solid #ddd;
            padding: 20px;
            margin: 10px;
            border-radius: 8px;
        }
    </style>
    <div class="card">
        <h3 class="card-title"></h3>
        <p class="card-content"></p>
    </div>
</template>

<script>
function createCard(title, content) {
    const template = document.getElementById('card-template');
    const clone = template.content.cloneNode(true);
    
    clone.querySelector('.card-title').textContent = title;
    clone.querySelector('.card-content').textContent = content;
    
    return clone;
}

// Usage
document.body.appendChild(createCard('Title', 'Content'));
</script>
```

#### Method 3: Class-based Components

```html
<div id="app"></div>

<script>
class Component {
    constructor(selector) {
        this.element = document.querySelector(selector);
    }
    
    render(html) {
        this.element.innerHTML = html;
    }
}

class HelloWorldComponent extends Component {
    constructor(selector) {
        super(selector);
        this.render(this.template());
    }
    
    template() {
        return `
            <h1>Hello World</h1>
            <p>This is a component</p>
        `;
    }
}

// Usage
new HelloWorldComponent('#app');
</script>
```

### Component Patterns

#### Accordion Component

```html
<div class="accordion">
    <button class="accordion-header">Section 1</button>
    <div class="accordion-content">
        <p>Content for section 1</p>
    </div>
    
    <button class="accordion-header">Section 2</button>
    <div class="accordion-content">
        <p>Content for section 2</p>
    </div>
</div>

<style>
.accordion-content {
    display: none;
}
.accordion-content.active {
    display: block;
}
</style>

<script>
document.querySelectorAll('.accordion-header').forEach(header => {
    header.addEventListener('click', () => {
        const content = header.nextElementSibling;
        content.classList.toggle('active');
    });
});
</script>
```

#### Modal Component

```html
<button onclick="openModal()">Open Modal</button>

<div id="modal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal()">&times;</span>
        <h2>Modal Title</h2>
        <p>Modal content goes here</p>
    </div>
</div>

<style>
.modal {
    display: none;
    position: fixed;
    z-index: 1000;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0,0,0,0.4);
}

.modal-content {
    background-color: white;
    margin: 15% auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
    max-width: 500px;
}

.close {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
    cursor: pointer;
}
</style>

<script>
function openModal() {
    document.getElementById('modal').style.display = 'block';
}

function closeModal() {
    document.getElementById('modal').style.display = 'none';
}
</script>
```

#### Tab Component

```html
<div class="tabs">
    <button class="tab-button active" onclick="openTab(event, 'tab1')">Tab 1</button>
    <button class="tab-button" onclick="openTab(event, 'tab2')">Tab 2</button>
    <button class="tab-button" onclick="openTab(event, 'tab3')">Tab 3</button>
</div>

<div id="tab1" class="tab-content active">
    <h3>Tab 1</h3>
    <p>Content for tab 1</p>
</div>

<div id="tab2" class="tab-content">
    <h3>Tab 2</h3>
    <p>Content for tab 2</p>
</div>

<div id="tab3" class="tab-content">
    <h3>Tab 3</h3>
    <p>Content for tab 3</p>
</div>

<style>
.tab-content {
    display: none;
}
.tab-content.active {
    display: block;
}
.tab-button.active {
    background-color: #ccc;
}
</style>

<script>
function openTab(evt, tabName) {
    // Hide all tab content
    document.querySelectorAll('.tab-content').forEach(tab => {
        tab.classList.remove('active');
    });
    
    // Remove active class from buttons
    document.querySelectorAll('.tab-button').forEach(button => {
        button.classList.remove('active');
    });
    
    // Show selected tab and mark button as active
    document.getElementById(tabName).classList.add('active');
    evt.currentTarget.classList.add('active');
}
</script>
```

---

## Component Lifecycle

### Document Lifecycle Events

```javascript
// DOMContentLoaded - DOM is ready
document.addEventListener('DOMContentLoaded', function() {
    console.log('DOM is ready');
    // Initialize components here
});

// Load - All resources loaded
window.addEventListener('load', function() {
    console.log('Page fully loaded');
    // Perform actions after all assets load
});

// Beforeunload - Before page unload
window.addEventListener('beforeunload', function(e) {
    e.preventDefault();
    e.returnValue = '';
});

// Unload - Page is unloading
window.addEventListener('unload', function() {
    console.log('Page is unloading');
});
```

### Component Initialization Pattern

```javascript
class ComponentManager {
    constructor() {
        this.components = [];
        this.init();
    }
    
    init() {
        document.addEventListener('DOMContentLoaded', () => {
            this.initializeComponents();
        });
    }
    
    register(component) {
        this.components.push(component);
    }
    
    initializeComponents() {
        this.components.forEach(component => {
            if (typeof component.init === 'function') {
                component.init();
            }
        });
    }
}

// Usage
const manager = new ComponentManager();
manager.register(myComponent1);
manager.register(myComponent2);
```

---

## Testing Components

### Manual Testing Checklist

- [ ] Visual appearance matches design
- [ ] Works across different browsers
- [ ] Responsive on mobile devices
- [ ] Keyboard navigation works
- [ ] Screen reader accessible
- [ ] No console errors
- [ ] Performance is acceptable
- [ ] Handles edge cases

### Automated Testing

```html
<script>
// Simple test framework
function test(description, callback) {
    try {
        callback();
        console.log(`✓ ${description}`);
    } catch (error) {
        console.error(`✗ ${description}`, error);
    }
}

function assert(condition, message) {
    if (!condition) {
        throw new Error(message || 'Assertion failed');
    }
}

// Tests
test('H1 element exists', () => {
    const h1 = document.querySelector('h1');
    assert(h1 !== null, 'H1 should exist');
});

test('H1 contains correct text', () => {
    const h1 = document.querySelector('h1');
    assert(h1.textContent === 'Hello World', 'H1 text should be "Hello World"');
});

test('Title is set correctly', () => {
    assert(document.title === 'Example Page', 'Title should be "Example Page"');
});
</script>
```

---

## Component Best Practices

### Accessibility

1. **Use semantic HTML**
   ```html
   <!-- Good -->
   <button>Click me</button>
   
   <!-- Bad -->
   <div onclick="handleClick()">Click me</div>
   ```

2. **Provide labels for form inputs**
   ```html
   <label for="username">Username:</label>
   <input type="text" id="username" name="username">
   ```

3. **Use ARIA when necessary**
   ```html
   <div role="button" tabindex="0" aria-label="Close dialog">×</div>
   ```

### Performance

1. **Minimize DOM manipulation**
2. **Use event delegation**
3. **Lazy load non-critical components**
4. **Avoid inline styles when possible**

### Maintainability

1. **Use consistent naming conventions**
2. **Keep components modular and reusable**
3. **Document component APIs**
4. **Follow single responsibility principle**

---

Last Updated: 2025-10-16
