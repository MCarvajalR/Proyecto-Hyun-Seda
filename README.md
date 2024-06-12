# Hyun Seda

![Hyun Seda](https://hyun.com.co/icons/android-chrome-192x192.png)

## Tabla de Contenido

- [Arquitectura de Software](#arquitectura-de-software)
- [Decisiones de Arquitectura](#decisiones-de-arquitectura)
- [Pruebas](#pruebas)
- [Documentación de las APIs REST con Swagger](#documentación-de-las-apis-rest-con-swagger)
- [Implementación de Autenticación y Autorización con JWT](#implementación-de-autenticación-y-autorización-con-jwt)
- [Demo en Video de la App](#demo-en-video-de-la-app)

---

## Arquitectura de Software

En el contexto de Hyun Seda, una empresa con artesanas mujeres cabezas de familia dedicada a la producción de seda sostenible, y considerando la necesidad de una solución propia y rentable para su plataforma de e-commerce y blog, con el fin de garantizar la viabilidad a largo plazo del negocio y mantener su presencia en línea, nos decidimos por la arquitectura en capas, el modelo MVC, microkernel, microservicios, orientado a eventos, y la implementación de principios SOLID, junto con el uso de métodos Observer y RabbitMQ. Descartamos otras opciones como monolítica o enriquecida de escritorio. Esto se decidió para lograr una arquitectura modular, flexible, y altamente adaptable, que permita una fácil gestión y escalabilidad del sistema, así como una comunicación eficiente entre los componentes. Aceptamos que esta decisión puede implicar una mayor complejidad en el desarrollo y mantenimiento del sistema, pero creemos que los beneficios en términos de escalabilidad, flexibilidad y adaptabilidad justifican esta elección.

En el contexto de la necesidad de garantizar la seguridad y el rendimiento del sistema, así como la eficiencia en la gestión de archivos multimedia para evitar el aumento exponencial de la base de datos, nos decidimos por la implementación de microservicios y una arquitectura orientada a eventos. Descartamos opciones como una arquitectura monolítica. Esto se decidió para lograr un sistema escalable y resistente, capaz de manejar grandes volúmenes de datos y picos de tráfico, y garantizar la seguridad de la información del cliente. Aceptamos que esta decisión puede requerir una mayor complejidad en el desarrollo y despliegue del sistema, pero creemos que los beneficios en términos de rendimiento, seguridad y eficiencia justifican esta elección.

En el contexto de la necesidad de una solución rentable y fácilmente mantenible, nos decidimos por el desarrollo de una aplicación de escritorio utilizando Java y SQLite como tecnologías principales. Descartamos opciones como una aplicación web o móvil debido a consideraciones de costos y facilidad de mantenimiento. Esto se decidió para lograr una implementación económica y de bajo mantenimiento, que aproveche las capacidades de Java y SQLite para proporcionar un rendimiento sólido y una gestión eficiente de la base de datos. Aceptamos que esta decisión puede limitar la accesibilidad del sistema en términos de dispositivos compatibles, pero creemos que los beneficios en términos de costo y facilidad de mantenimiento justifican esta elección.

---

## Decisiones de Arquitectura

En el contexto de Hyun Seda, una empresa con artesanas mujeres cabezas de familia dedicada a la producción de seda sostenible, y considerando la necesidad de una solución propia y rentable para su plataforma de e-commerce y blog, con el fin de garantizar la viabilidad a largo plazo del negocio y mantener su presencia en línea, nos decidimos por la arquitectura en capas, el modelo MVC, microkernel, microservicios, orientado a eventos, y la implementación de principios SOLID, junto con el uso de métodos Observer y RabbitMQ. Descartamos otras opciones como monolítica o enriquecida de escritorio. Esto se decidió para lograr una arquitectura modular, flexible, y altamente adaptable, que permita una fácil gestión y escalabilidad del sistema, así como una comunicación eficiente entre los componentes. Aceptamos que esta decisión puede implicar una mayor complejidad en el desarrollo y mantenimiento del sistema, pero creemos que los beneficios en términos de escalabilidad, flexibilidad y adaptabilidad justifican esta elección.

En el contexto de la necesidad de garantizar la seguridad y el rendimiento del sistema, así como la eficiencia en la gestión de archivos multimedia para evitar el aumento exponencial de la base de datos, nos decidimos por la implementación de microservicios y una arquitectura orientada a eventos. Descartamos opciones como una arquitectura monolítica. Esto se decidió para lograr un sistema escalable y resistente, capaz de manejar grandes volúmenes de datos y picos de tráfico, y garantizar la seguridad de la información del cliente. Aceptamos que esta decisión puede requerir una mayor complejidad en el desarrollo y despliegue del sistema, pero creemos que los beneficios en términos de rendimiento, seguridad y eficiencia justifican esta elección.

En el contexto de la necesidad de una solución rentable y fácilmente mantenible, nos decidimos por el desarrollo de una aplicación de escritorio utilizando Java y SQLite como tecnologías principales. Descartamos opciones como una aplicación web o móvil debido a consideraciones de costos y facilidad de mantenimiento. Esto se decidió para lograr una implementación económica y de bajo mantenimiento, que aproveche las capacidades de Java y SQLite para proporcionar un rendimiento sólido y una gestión eficiente de la base de datos. Aceptamos que esta decisión puede limitar la accesibilidad del sistema en términos de dispositivos compatibles, pero creemos que los beneficios en términos de costo y facilidad de mantenimiento justifican esta elección.

---

## Pruebas

![Software Test Product](https://github.com/MCarvajalR/Proyecto-Hyun-Seda/blob/master/TestCreateProd.png)
*Este es un ejemplo de la implementacion de Tests para validar la creacion de Productos*


![Software Test GetProductById](https://github.com/MCarvajalR/Proyecto-Hyun-Seda/blob/master/TestGetById.png)
*Este es un ejemplo de la implementacion de Tests para validar busquedas por Id*

---

## Documentación de las APIs REST con Swagger

![Software Swagger Doc](https://github.com/MCarvajalR/Proyecto-Hyun-Seda/blob/master/SwaggerDoc.png)

*Este es una demostración de la documentación swagger que empleamos para los métodos*

---

## Implementación de Autenticación y Autorización con JWT

![Software JWT Aut Filter](https://github.com/MCarvajalR/Proyecto-Hyun-Seda/blob/master/JWTAut.png)
*Esta es una demostracion de la implemetacion del JWTAuthenticationFilter para validar los usuarios en el proyecto.*




![Software JWT Util](https://github.com/MCarvajalR/Proyecto-Hyun-Seda/blob/master/JWTUtil.png)
*Esta es una demostracion de la implemetacion del JWTUltil para generar y validar los tokens.*

---

## Demo en Video de la App

https://drive.google.com/file/d/18BXmd5F5iKFX5ngxPZEVmpN5aBaBZpqY/preview

---

Visita mi [repositorio en GitHub](https://github.com/MCarvajalR/Proyecto-Hyun-Seda) para más detalles. :D
