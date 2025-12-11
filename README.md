# 🎮 GameDJ – Backend (Kotlin + Spring Boot)

Este repositorio contiene el **backend del proyecto GameDJ**, desarrollado en **Kotlin** con **Spring Boot**.  
El backend expone una API REST para gestionar:

- Juegos 🎮  
- Usuarios 👤  
- Reseñas 📝  

Este servicio es consumido por la aplicación Android del proyecto.

---

## 🚀 Tecnologías Utilizadas

- **Kotlin**  
- **Spring Boot 3.x**  
- **Spring Web** (REST)  
- **Spring Data JPA**  
- **Maven**  
- **MySQL** 

---

## 📦 Requisitos Previos

Asegúrate de tener instalado:

- **Java 17**
- **Maven**
- **IntelliJ**

---


git clone https://github.com/Dmente97/GameDJ-Backend.git

🔌 Endpoints Principales
Juegos
Método	Endpoint	Descripción
GET	/api/games	Obtener lista de juegos
GET	/api/games/{id}	Obtener juego por ID
POST	/api/games	Crear nuevo juego
Reseñas
Método	Endpoint	Descripción
GET	/api/games/{id}/reviews	Reseñas de un juego
POST	/api/games/{id}/reviews	Crear reseña para un juego
Usuarios
Método	Endpoint	Descripción
GET	/api/users	Obtener usuarios

👨‍💼 Autor

Daniel Méndez
Estudiante – Proyecto para entrega académica.
