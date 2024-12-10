
# Automation Selenium Java UI

Proyecto de Automatización de UI desarrollado en **Java** utilizando **Selenium** y **TestNG**, con integración de reportes detallados generados con **Allure** y ejecución automatizada mediante **GitHub Actions**. Este proyecto está diseñado para demostrar habilidades en automatización de pruebas funcionales, diseño robusto de pruebas y generación de reportes accesibles.

---

## 📁 Estructura del Proyecto

```plaintext
automation-selenium-java-ui/
│
├── .github/
│   └── workflows/
│       └── ci.yml               # Configuración de GitHub Actions
│
├── selenium-ui/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   ├── base/        # Clases base para la configuración del driver y reutilización de lógica
│   │   │   │   │   ├── BasePage.java
│   │   │   │   │   └── BaseTest.java
│   │   │   │   ├── pages/       # Clases que representan las páginas del sistema bajo prueba
│   │   │   │   │   ├── CategoryPage.java
│   │   │   │   │   ├── HomePage.java
│   │   │   │   │   └── ...
│   │   │   │   ├── steps/       # Pasos de alto nivel reutilizables
│   │   │   │   │   └── MercadoLibreSteps.java
│   │   │   │   └── utils/       # Utilidades generales
│   │   │   │       └── ConfigReader.java
│   │   │   └── resources/       # Archivos de configuración
│   │   │       ├── config.properties
│   │   │       └── allure.properties
│   │   └── test/
│   │       ├── java/
│   │       │   └── tests/       # Clases de prueba
│   │       │       └── MercadoLibreTest.java
│   └── target/                  # Archivos generados durante la ejecución (resultados de pruebas, reportes)
│
├── docs/                        # Carpeta utilizada para GitHub Pages
│
├── pom.xml                      # Configuración de Maven
├── .gitignore                   # Archivos y carpetas ignorados por Git
└── README.md                    # Descripción del proyecto
```

---

## 📚 Tecnologías y Librerías Utilizadas

- **Lenguaje**: Java 21
- **Framework de Pruebas**: TestNG
- **Automatización UI**: Selenium WebDriver
- **Gestor de Dependencias**: Maven
- **Reportes**: Allure Framework
- **Integración Continua**: GitHub Actions
- **Gestión de Navegadores**: WebDriverManager

---

## 🚀 Funcionalidades

- 🧩 Diseño basado en **Page Object Model (POM)**.
- 🔄 Ejecución de pruebas parametrizadas por navegador y grupo.
- 📊 Reportes interactivos generados con **Allure**.
- 🌐 Despliegue de reportes en **GitHub Pages** para acceso directo desde el navegador.
- 💻 Opciones para ejecución con o sin interfaz gráfica (headless mode).
- 🔧 Configuración flexible a través de archivos de propiedades.

---

## ⚙️ Configuración del Proyecto

### 1. Clonar el Repositorio
```bash
git clone https://github.com/Negroove/automation-selenium-java-ui.git
cd automation-selenium-java-ui
```

### 2. Instalar Dependencias
Asegúrate de tener **Maven** instalado y ejecuta:
```bash
mvn clean install
```

### 3. Configurar Propiedades
Edita el archivo `config.properties` ubicado en `src/main/resources/` para ajustar las configuraciones necesarias (como la URL base y otros parámetros).

---

## 🎯 Ejecución de Pruebas

### Ejecución Básica
```bash
mvn clean test
```

### Ejecución por Grupos
```bash
mvn clean test -Dgroups={nombre_del_grupo}
```
Ejemplo:
```bash
mvn clean test -Dgroups=regresion
```

### Especificar Navegador
```bash
mvn clean test -Dbrowser={nombre_del_navegador}
```
Ejemplo:
```bash
mvn clean test -Dbrowser=firefox
```

### Modo Headless
```bash
mvn clean test -Dbrowser=chrome -Dheadless=true
```

---

## 📊 Generación y Visualización de Reportes

### Generar Reporte de Allure
```bash
allure generate --clean selenium-ui/target/allure-results -o docs
```

### Visualizar Reporte Localmente
```bash
allure serve selenium-ui/target/allure-results
```

### Reportes en GitHub Pages
Los reportes se despliegan automáticamente en la rama `gh-pages` tras cada ejecución en la rama `master`. Accede a los reportes desde:
[**GitHub Pages Report**](https://negroove.github.io/automation-selenium-java-ui/)

---

## 🔄 Integración Continua (CI)

El proyecto utiliza **GitHub Actions** para ejecutar pruebas y desplegar reportes. El flujo está configurado en el archivo `.github/workflows/ci.yml` y realiza las siguientes tareas:

1. Ejecuta las pruebas tras cada push a la rama `master`.
2. Genera los reportes con Allure.
3. Despliega los reportes en **GitHub Pages** automáticamente.

---

## 🛠 Librerías Incluidas en el `pom.xml`

### Selenium
```xml
<dependency>
  <groupId>org.seleniumhq.selenium</groupId>
  <artifactId>selenium-java</artifactId>
  <version>4.27.0</version>
</dependency>
```

### TestNG
```xml
<dependency>
  <groupId>org.testng</groupId>
  <artifactId>testng</artifactId>
  <version>7.10.2</version>
</dependency>
```

### WebDriverManager
```xml
<dependency>
  <groupId>io.github.bonigarcia</groupId>
  <artifactId>webdrivermanager</artifactId>
  <version>5.9.2</version>
</dependency>
```

### Allure TestNG
```xml
<dependency>
  <groupId>io.qameta.allure</groupId>
  <artifactId>allure-testng</artifactId>
  <version>2.15.0</version>
</dependency>
```

---


