# 🧱 Hexagonal Architecture Example

Este repositorio es un ejemplo **claro, limpio y funcional** de cómo aplicar **la arquitectura hexagonal (puertos y adaptadores)** de forma **correcta y pura** usando Java y Spring Boot.

## 💡 Objetivo

Demostrar que es **totalmente posible** separar el núcleo de negocio de los detalles técnicos, incluso trabajando con frameworks como Spring Boot.

Este proyecto fue construido desde cero con el único propósito de **respetar al máximo los principios de la arquitectura hexagonal**, sin atajos ni acoplamientos innecesarios.

## 🧭 Estructura general

- `domain/`: entidades y lógica de negocio
- `application/`: casos de uso y contratos (puertos de entrada y salida)
- `infrastructure/`: adaptadores (API REST, base de datos, configuración con Spring)

El **núcleo (dominio + aplicación)** no depende en absoluto de ningún framework ni tecnología externa
(Bueno si, Lombok. Pero solo fue usado para reducir el boilerplate).
Todas las dependencias apuntan hacia adentro, tal como dicta el modelo de **puertos y adaptadores**.

---