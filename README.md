# 📰 DADA News - Daily News Web Application

A modern Spring Boot web application that displays daily news using the NewsAPI. Built with a beautiful, responsive design and comprehensive testing suite.

## ✨ Features

- 📰 **Real-time News**: Latest news articles from NewsAPI with your API key
- 🏷️ **Smart Category Filtering**: Filter by Business, Technology, Sports, Health, Entertainment
- 📱 **Responsive Design**: Mobile-first approach with Bootstrap 5
- ⚡ **Fast Loading**: Optimized with Spring WebFlux for reactive programming
- 🎨 **Modern UI**: Clean design with hover effects and smooth transitions
- 🧪 **Comprehensive Testing**: 14 unit tests covering all components
- 🔧 **Easy Configuration**: Simple setup with Maven and Spring Boot

## 🚀 Technology Stack

- **Backend**: Spring Boot 3.2.0
- **Template Engine**: Thymeleaf
- **Web Client**: Spring WebFlux (Reactive)
- **Frontend**: Bootstrap 5, Font Awesome 6
- **Build Tool**: Maven
- **Java Version**: 17
- **Testing**: JUnit 5, Mockito, Spring Test

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Internet connection (for NewsAPI)
- NewsAPI key (free at [newsapi.org](https://newsapi.org/))

## 🛠️ Quick Start

### 1. Clone and Navigate
```bash
git clone <repository-url>
cd daily-news-app
```

### 2. Configure API Key
The application is pre-configured with an API key. To use your own:
```properties
# In src/main/resources/application.properties
news.api.key=your-api-key-here
```

### 3. Build and Run
```bash
# Build the application
mvn clean install

# Run the application
mvn spring-boot:run
```

### 4. Access DADA News
Open your browser and go to: **http://localhost:8080**

## 🎯 API Endpoints

| Endpoint | Description | Parameters |
|----------|-------------|------------|
| `GET /` | Home page with all news | None |
| `GET /category` | Filtered news by category | `category` (business, technology, sports, health, entertainment) |

## 📁 Project Structure

```
📦 DADA News Application
├── 📁 src/main/java/com/example/dailynewsapp/
│   ├── 🎮 controller/
│   │   └── NewsController.java          # Web endpoints
│   ├── 📊 model/
│   │   ├── NewsArticle.java            # Article data model
│   │   ├── NewsResponse.java           # API response model
│   │   └── Source.java                 # News source model
│   ├── ⚙️ service/
│   │   └── NewsService.java            # NewsAPI integration
│   └── 🚀 DailyNewsAppApplication.java # Main Spring Boot app
├── 📁 src/main/resources/
│   ├── 📄 templates/
│   │   └── index.html                  # Thymeleaf template
│   └── ⚙️ application.properties       # Configuration
└── 📁 src/test/java/com/example/dailynewsapp/
    ├── 🧪 controller/                  # Controller tests
    ├── 🧪 model/                       # Model tests
    ├── 🧪 service/                     # Service tests
    └── 🧪 DailyNewsAppApplicationTest.java # Integration tests
```

## 🧪 Testing

### Run All Tests
```bash
mvn test
```

### Test Coverage
- **14 Total Tests** ✅
- **Controller Tests**: 4 tests (endpoints, error handling)
- **Model Tests**: 6 tests (getters, setters, constructors)
- **Service Tests**: 3 tests (configuration, instantiation)
- **Integration Tests**: 1 test (Spring context loading)

### Test Results
```
Tests run: 14, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

## ⚙️ Configuration

### Application Properties
```properties
# News API Configuration
news.api.key=8ee47ef486c94452ac826695e273067f
news.api.url=https://newsapi.org/v2/top-headlines

# Server Configuration
server.port=8080

# Thymeleaf Configuration
spring.thymeleaf.cache=false
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html

# Logging
logging.level.com.example=DEBUG
```

## 🎨 UI Features

### Design Elements
- **Header**: "📰 DADA News" with gradient background
- **Navigation**: Category filter buttons with hover effects
- **News Cards**: Responsive cards with images, titles, descriptions
- **Footer**: "Powered by deepak - DADA ai"
- **Icons**: Font Awesome with emoji fallbacks

### Responsive Breakpoints
- **Mobile**: Single column layout
- **Tablet**: Two column layout
- **Desktop**: Three column layout

## 🔧 Troubleshooting

### Common Issues & Solutions

| Issue | Solution |
|-------|----------|
| **Port 8080 already in use** | Kill process: `taskkill /PID <PID> /F` or change port in `application.properties` |
| **"Host is not specified" error** | Check API URL configuration in `application.properties` |
| **No news displayed** | Verify API key, check internet connection, review logs |
| **CDN resources not loading** | Application includes fallback CSS and emoji icons |

### Debug Mode
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--debug"
```

## 📊 Performance

- **Startup Time**: ~3-4 seconds
- **Memory Usage**: Optimized with Spring Boot auto-configuration
- **Response Time**: Fast with reactive WebClient
- **Caching**: Thymeleaf template caching disabled for development

## 🚀 Deployment

### JAR Deployment
```bash
# Build executable JAR
mvn clean package

# Run JAR
java -jar target/daily-news-app-1.0.0.jar
```

### Docker (Optional)
```dockerfile
FROM openjdk:17-jdk-slim
COPY target/daily-news-app-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

## 🤝 Contributing

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/amazing-feature`)
3. **Commit** your changes (`git commit -m 'Add amazing feature'`)
4. **Push** to the branch (`git push origin feature/amazing-feature`)
5. **Open** a Pull Request

### Development Guidelines
- Follow Java naming conventions
- Add tests for new functionality
- Update documentation
- Ensure all tests pass

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Deepak (DADA AI)**
- Project: DADA News Application
- Technology: Spring Boot, Thymeleaf, NewsAPI

## 🙏 Acknowledgments

- [NewsAPI](https://newsapi.org/) for providing news data
- [Spring Boot](https://spring.io/projects/spring-boot) for the framework
- [Bootstrap](https://getbootstrap.com/) for UI components
- [Font Awesome](https://fontawesome.com/) for icons

## 📞 Support

For support, questions, or feature requests:
- Open an issue in the repository
- Check the troubleshooting section above
- Review the application logs for detailed error information

---

**🎉 Enjoy your DADA News experience! Stay informed with the latest news from around the world.**