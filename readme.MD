## ZIPKIN
es usado para llevar una trazabilidad de logs en todos los microservicios

## REDIS
se usa como una base de datos en memoria en este caso se usara para evitar el numero de peticiones por
segundo por usuario pra evitar ataques DDOS

# RATE LIMITER
rate limiter es un patron de diseño que se usa para definiri cuantas peticiones puede tener un 
usuario por segundo se define desde un bean de la aplicacion con el KeyRestore pero aparte de esto
necesitamos a Redis como dependencias para usarlo

# USAR LOS NUEVOS SERVICIOS
para usar los serivicios como zipkin o redis debemos desplegar el docker con esas aplicaciones
y correrlas en el puerto que deberian correr originalmente

## SPRING SECURITY
se usa para proteger el api gateway
los microservicios tienen un scope interno para solo poder ser llamados desde un servicio en especifico