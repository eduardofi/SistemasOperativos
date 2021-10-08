# SistemasOperativos

## SIMULADOR DE PROCESOS Y MEMORIA – PARTE 1
**Objetivo.**
- Implementar los conceptos del curso relacionados con procesos realizando una implementación que permita simular la ejecución de procesos en un sistema operativo
- Que el alumno pueda retomar sus habilidades de programación aplicándolo a un concepto fundamental del curso
## Introducción

Un proceso se puede definir de diferentes formas ya que es una de las unidades fundamentales de trabajo de un sistema operativo.

Un proceso básicamente es un programa que se encuentra en ejecución, aunque de manera más formal se puede definir como cualquier secuencia de operaciones que están ejecutándose en memoria principal que realiza una o varias acciones sobre ciertos datos.

La estructura de un proceso cuenta con 4 elementos básicos:
- Sección de texto
- Sección de datos
- Pila
- Heap


El estado de un proceso depende de la actividad que esté realizando
- Nuevo: El proceso está siendo creado
- En ejecución: El cpu ejecuta las instrucciones
- Espera: Se encuentra en un estado que depende de un suceso externo
- Preparado: Listo para que se le asigne un procesador
- Terminado: Ha concluido la ejecución

Solo puede haber un proceso ejecutándose en cualquier procesador en un instante de tiempo pero puede haber muchos procesos preparados y en espera

## DESARROLLO. 

Actividades para el desarrollo de la práctica.

### PARTE 1.- Requerimientos y funcionalidades del programa

Se deberá realizar un programa que se capaz de simular la ejecución de procesos en un sistema
operativo

El usuario final tomará el rol del sistema operativo y podrá interactuar con el simulador realizando una serie de actividades relacionadas con la creación y ejecución de procesos

Se podrá seleccionar alguna de las opciones que proporciona el programa con diferentes acciones relacionadas con la creación y ejecución de procesos

Al iniciar la ejecución del programa, habrá tabla global de “memoria disponible” (2048 localidades) Esta será la memoria disponible para crear “procesos”

En la ejecución, el usuario contará con un menú de opciones donde podrá realizar las siguientes acciones:
- Crear Proceso nuevo
  - El usuario podrá escribir el nombre del nuevo proceso.
  - El programa verificará si hay memoria disponible para la creación, en caso de ser así lo creará, de lo contrario informará que no se puede crear y que es necesario ejecutar o matar otros procesos
  - El programa asignará un número identificador único para el proceso nuevo
  - El programa asignará un número aleatorio de instrucciones de ese proceso (10-30)
  - El programa asignará un espacio que ocupará el proceso (esta cantidad será de 64, 128, 256 o 512 localidades)
  - Después de crear el proceso ingresará a la cola general del sistema (cola de procesos preparados)
- Ver estado actual del sistema
  - Número de procesos listos (en cola)
  - Lista con el nombre de los procesos finalizados exitosamente
  - Lista de procesos finalizados antes de tiempo (eliminados)
  - Ver estado de la memoria (localidades ocupadas por procesos)

EN la memoria se debe detallar, qué procesos están ocupando cuales localidades:
Localidad proceso
```
1 word.exe
2 word.exe
..
64 juego.exe
65 juego.exe
66 juego.exe
--- --
```
- Imprimir cola de procesos
  - Esta opción mostrará la lista de los procesos preparados para su ejecución.
  - De cada proceso se debe mostrar su nombre, su id, y las instrucciones pendientes por ejecutar 
  - El proceso que se encuentre al frente de la cola será “el proceso activo”
- Ver proceso actual
  - Nombre del proceso
  - Id único
  - Instrucciones totales
  - Instrucciones ejecutadas
  - Direcciones de memoria asignadas
- Ejecutar proceso actual
  - Implica realizar 5 instrucciones del proceso, después de esas 5 instrucciones automáticamente se colocará al final de la cola de listos o bien si al ejecutar
esas 5 instrucciones llega a su finalización deberá mostrar un mensaje de que el proceso ha concluido su ejecución y deberá liberar la memoria
  - La ejecución implica “restar” 5 instrucciones totales del proceso
- Pasar al proceso siguiente
  - Envía el proceso actual al final de la cola sin ejecutar instrucciones    
  - Coloca el siguiente como activo
- Matar proceso actual
  - Simplemente deberá liberar la memoria que utilizaba ese proceso y guardarlo en el registro de procesos eliminados
  - Informar cuantas instrucciones pendientes tenía el proceso
- Salir del programa
  - Al seleccionar esta opción se mostrará la lista de procesos

### PARTE 2.- Forma de entrega

- La práctica deberá ser entregado en EDUCAFI en un solo archivo comprimido, en caso de que exceda el tamaño límite, se deberá subir a alguna plataforma de almacenamiento de archivos (OneDrive, GoogleDrive, DropBox) y subir a educafi la liga
- Es obligatorio Incluir los siguientes elementos:
  - Trabajo escrito del reporte de la práctica: objetivo, introducción, análisis de desarrollo del programa y conclusiones individuales*.
  - Código fuente del programa realizado
  - (Opcional) Imágenes, diagramas a mano o a computadora, bitácoras de reunión, cualquier tipo de material que el alumno considere conveniente para completar su
documentación;
  - El programa se deberá realizar en Java o en Lenguaje C. 
  - Se deberá realizar un video demostrativo con la con la ejecución del programa explicando
los puntos más importantes del código y con la demostración de la ejecución del programa en cada una de sus opciones (En caso de que haya elementos que fallen o que no se hayan logrado, se debe indicar aquí). Extensión máxima de 25 min

## *CONCLUSIONES

Escribe las conclusiones de tu práctica en función del cumplimiento de los objetivos.
Escribe comentarios acerca de qué tanto aportó la elaboración de la práctica en la comprensión del concepto general de procesos.
También escribe comentarios acerca de tu experiencia en la elaboración del programa
