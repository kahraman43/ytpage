# Usage Guide

## Getting Started

This guide provides detailed instructions on how to use and extend the project.

## Table of Contents

1. [Quick Start](#quick-start)
2. [Development Setup](#development-setup)
3. [Usage Examples](#usage-examples)
4. [Advanced Topics](#advanced-topics)
5. [Troubleshooting](#troubleshooting)

---

## Quick Start

### Viewing the Application

The simplest way to view the application is to open `index.html` directly in your browser:

```bash
# Navigate to the project directory
cd /workspace

# Open in default browser (Linux)
xdg-open index.html

# Or specify a browser
firefox index.html
google-chrome index.html
```

### Using a Local Server

For a more production-like environment, use a local web server:

#### Python HTTP Server

```bash
# Python 3
python -m http.server 8000

# Python 2
python -m SimpleHTTPServer 8000
```

Then navigate to: `http://localhost:8000/index.html`

#### Node.js HTTP Server

```bash
# Install http-server globally
npm install -g http-server

# Run server
http-server -p 8000
```

#### PHP Built-in Server

```bash
php -S localhost:8000
```

---

## Development Setup

### Prerequisites

- A modern web browser (Chrome, Firefox, Safari, Edge)
- A text editor or IDE (VS Code, Sublime Text, Atom)
- (Optional) A local web server for development

### Project Structure

```
/workspace/
├── index.html              # Main HTML file
├── API_DOCUMENTATION.md    # API documentation
├── USAGE_GUIDE.md          # This file
└── COMPONENTS.md           # Component documentation
```

### Setting Up for Development

1. **Clone or download the project**
   ```bash
   git clone <repository-url>
   cd workspace
   ```

2. **Open in your editor**
   ```bash
   code .  # VS Code
   subl .  # Sublime Text
   ```

3. **Start development server** (optional)
   ```bash
   python -m http.server 8000
   ```

---

## Usage Examples

### Example 1: Basic HTML Page Display

The current implementation displays a simple "Hello World" heading.

**Code:**
```html
<!DOCTYPE html>
<html>
<head>
    <title>Example Page</title>
</head>
<body>
    <h1>Hello World</h1>
</body>
</html>
```

**Expected Output:**
- Browser tab title: "Example Page"
- Page displays: Large heading with text "Hello World"

### Example 2: Adding Custom Content

To add more content to the page:

```html
<!DOCTYPE html>
<html>
<head>
    <title>Example Page</title>
</head>
<body>
    <h1>Hello World</h1>
    <p>This is a paragraph of text.</p>
    <ul>
        <li>List item 1</li>
        <li>List item 2</li>
        <li>List item 3</li>
    </ul>
</body>
</html>
```

### Example 3: Adding Styles

#### Inline Styles

```html
<body>
    <h1 style="color: blue; font-family: Arial;">Hello World</h1>
</body>
```

#### Internal Stylesheet

```html
<head>
    <title>Example Page</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        h1 {
            color: #2c3e50;
            border-bottom: 3px solid #3498db;
            padding-bottom: 10px;
        }
    </style>
</head>
```

#### External Stylesheet

Create `styles.css`:
```css
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 20px;
}

h1 {
    color: #333;
}
```

Link in HTML:
```html
<head>
    <title>Example Page</title>
    <link rel="stylesheet" href="styles.css">
</head>
```

### Example 4: Adding Interactivity with JavaScript

#### Inline Script

```html
<body>
    <h1 id="greeting">Hello World</h1>
    <button onclick="changeGreeting()">Click Me</button>
    
    <script>
        function changeGreeting() {
            document.getElementById('greeting').textContent = 'Hello, JavaScript!';
        }
    </script>
</body>
```

#### External Script

Create `script.js`:
```javascript
document.addEventListener('DOMContentLoaded', function() {
    const heading = document.querySelector('h1');
    heading.addEventListener('click', function() {
        this.style.color = this.style.color === 'red' ? 'black' : 'red';
    });
});
```

Link in HTML:
```html
<body>
    <h1>Hello World</h1>
    <script src="script.js"></script>
</body>
```

### Example 5: Responsive Design

```html
<head>
    <title>Example Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }
        
        h1 {
            font-size: 2em;
        }
        
        @media (max-width: 768px) {
            h1 {
                font-size: 1.5em;
            }
            body {
                padding: 10px;
            }
        }
        
        @media (max-width: 480px) {
            h1 {
                font-size: 1.2em;
            }
        }
    </style>
</head>
```

### Example 6: Accessibility Enhancements

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Example Page - Accessible Version</title>
</head>
<body>
    <header role="banner">
        <h1>Hello World</h1>
    </header>
    
    <main role="main">
        <nav role="navigation" aria-label="Main navigation">
            <ul>
                <li><a href="#section1">Section 1</a></li>
                <li><a href="#section2">Section 2</a></li>
            </ul>
        </nav>
        
        <article>
            <h2 id="section1">Section 1</h2>
            <p>Content for section 1</p>
        </article>
    </main>
    
    <footer role="contentinfo">
        <p>&copy; 2025 Example Page</p>
    </footer>
</body>
</html>
```

---

## Advanced Topics

### Building a Single Page Application (SPA)

Transform the static page into a dynamic SPA:

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SPA Example</title>
    <style>
        .page { display: none; }
        .page.active { display: block; }
    </style>
</head>
<body>
    <nav>
        <button onclick="showPage('home')">Home</button>
        <button onclick="showPage('about')">About</button>
        <button onclick="showPage('contact')">Contact</button>
    </nav>
    
    <div id="home" class="page active">
        <h1>Home</h1>
        <p>Welcome to the home page</p>
    </div>
    
    <div id="about" class="page">
        <h1>About</h1>
        <p>About us page content</p>
    </div>
    
    <div id="contact" class="page">
        <h1>Contact</h1>
        <p>Contact information</p>
    </div>
    
    <script>
        function showPage(pageId) {
            // Hide all pages
            document.querySelectorAll('.page').forEach(page => {
                page.classList.remove('active');
            });
            
            // Show selected page
            document.getElementById(pageId).classList.add('active');
        }
    </script>
</body>
</html>
```

### Integrating Modern Frameworks

#### Using React (via CDN)

```html
<!DOCTYPE html>
<html>
<head>
    <title>React Example</title>
    <script crossorigin src="https://unpkg.com/react@18/umd/react.production.min.js"></script>
    <script crossorigin src="https://unpkg.com/react-dom@18/umd/react-dom.production.min.js"></script>
    <script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
</head>
<body>
    <div id="root"></div>
    
    <script type="text/babel">
        function App() {
            const [count, setCount] = React.useState(0);
            
            return (
                <div>
                    <h1>Hello World</h1>
                    <p>Count: {count}</p>
                    <button onClick={() => setCount(count + 1)}>Increment</button>
                </div>
            );
        }
        
        ReactDOM.render(<App />, document.getElementById('root'));
    </script>
</body>
</html>
```

#### Using Vue.js (via CDN)

```html
<!DOCTYPE html>
<html>
<head>
    <title>Vue Example</title>
    <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
</head>
<body>
    <div id="app">
        <h1>{{ message }}</h1>
        <button @click="updateMessage">Click Me</button>
    </div>
    
    <script>
        const { createApp } = Vue;
        
        createApp({
            data() {
                return {
                    message: 'Hello World'
                }
            },
            methods: {
                updateMessage() {
                    this.message = 'Hello Vue!';
                }
            }
        }).mount('#app');
    </script>
</body>
</html>
```

### Performance Optimization

#### Lazy Loading Images

```html
<img src="placeholder.jpg" 
     data-src="actual-image.jpg" 
     loading="lazy" 
     alt="Description">

<script>
    // Intersection Observer for older browsers
    const images = document.querySelectorAll('img[data-src]');
    
    const imageObserver = new IntersectionObserver((entries, observer) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                const img = entry.target;
                img.src = img.dataset.src;
                img.removeAttribute('data-src');
                observer.unobserve(img);
            }
        });
    });
    
    images.forEach(img => imageObserver.observe(img));
</script>
```

#### Minification

For production, minify HTML:
```bash
# Using html-minifier
npm install -g html-minifier
html-minifier --collapse-whitespace --remove-comments index.html -o index.min.html
```

---

## Troubleshooting

### Common Issues

#### 1. Page Doesn't Display Correctly

**Problem:** HTML not rendering as expected

**Solutions:**
- Check for syntax errors in HTML
- Ensure DOCTYPE is present
- Validate HTML at https://validator.w3.org/
- Check browser console for errors (F12)

#### 2. Styles Not Applying

**Problem:** CSS styles not working

**Solutions:**
- Verify CSS syntax
- Check selector specificity
- Ensure stylesheet is linked correctly
- Clear browser cache (Ctrl+Shift+R)
- Check for typos in class/id names

#### 3. JavaScript Not Running

**Problem:** Scripts not executing

**Solutions:**
- Check browser console for errors
- Ensure script tags are placed correctly (usually before `</body>`)
- Verify JavaScript syntax
- Check if DOM is loaded before accessing elements
- Look for typos in function names

#### 4. CORS Issues with Local Files

**Problem:** Can't load resources from file://

**Solutions:**
- Use a local web server instead of file://
- Use Python: `python -m http.server`
- Use Node.js: `npx http-server`
- Configure browser to allow local file access (not recommended)

#### 5. Mobile Display Issues

**Problem:** Page doesn't look right on mobile

**Solutions:**
- Add viewport meta tag: `<meta name="viewport" content="width=device-width, initial-scale=1.0">`
- Use responsive CSS (media queries)
- Test with browser dev tools mobile view
- Avoid fixed widths, use percentages or max-width

### Debug Tools

#### Browser Developer Tools

```javascript
// Console logging
console.log('Debug message');
console.error('Error message');
console.warn('Warning message');

// DOM inspection
console.dir(document.body);

// Performance monitoring
console.time('operation');
// ... code to measure
console.timeEnd('operation');
```

#### HTML Validation

- W3C Validator: https://validator.w3.org/
- Browser DevTools: Elements/Inspector tab
- Lighthouse audit (Chrome): F12 > Lighthouse

---

## Best Practices Checklist

- [ ] Include DOCTYPE declaration
- [ ] Add lang attribute to HTML tag
- [ ] Include charset meta tag
- [ ] Add viewport meta tag for responsive design
- [ ] Use semantic HTML elements
- [ ] Provide alt text for images
- [ ] Keep CSS and JavaScript in separate files (for larger projects)
- [ ] Minify resources for production
- [ ] Test across different browsers
- [ ] Validate HTML and CSS
- [ ] Check accessibility with screen readers
- [ ] Optimize images and assets
- [ ] Implement proper error handling in JavaScript
- [ ] Use version control (git)
- [ ] Document code changes

---

## Additional Resources

### Learning Resources
- [MDN Web Docs](https://developer.mozilla.org/)
- [W3Schools](https://www.w3schools.com/)
- [CSS Tricks](https://css-tricks.com/)
- [JavaScript.info](https://javascript.info/)

### Tools
- [Can I Use](https://caniuse.com/) - Browser compatibility
- [CodePen](https://codepen.io/) - Online code editor
- [JSFiddle](https://jsfiddle.net/) - Test code snippets

### Accessibility
- [WAVE Web Accessibility Evaluation Tool](https://wave.webaim.org/)
- [axe DevTools](https://www.deque.com/axe/devtools/)
- [WCAG Guidelines](https://www.w3.org/WAI/WCAG21/quickref/)

---

Last Updated: 2025-10-16
