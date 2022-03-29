# Тестовый проект по использованию RPC 
## Кодовая база для технологий:
- RPC jsonrpc4j
- Дефолтные Serializer для нестандартных случаев
- Hibernate Converter для встраеваемой в сущность Json-ки в базу
- Парсер для обработки hql запросов от клиента
- Liquibase
- Hibernate Cache

## CI
Локально поднимается Jenkins с pipeline для сборки и загрузки image в Docker Hub  
** Планируется подключения шага проверки кода в  SonarQube 
