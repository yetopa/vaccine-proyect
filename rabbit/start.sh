#docker run -d --hostname my-rabbit --name some-rabbit rabbitmq:3
#docker run -d --hostname my-rabbit -p 4369:4369 -p 5671:5671 -p 5672:5672 -p 15671:15671 -p 15672:15672 -p25672:25672  --name some-rabbit rabbitmq:3-management
#docker run -d --hostname my-rabbit  --name some-rabbit-temporal-stamdup rabbitmq:3-management

# docker run -d --hostname my-rabbit  --name some-rabbit rabbitmq:3-management
docker stop some-rabbit
docker-compose build
docker-compose images
docker-compose up -d