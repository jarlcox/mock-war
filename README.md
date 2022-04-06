# README

```sh
# 构建镜像
mvn clean package
docker build -t mock-war .

# 创建网络
docker network create -d bridge  --subnet 172.22.0.0/24 --gateway 172.22.0.1 devnet

# 运行redis
docker run -d -ti --name redis-dev \
  --network=devnet --ip=172.22.0.11 -p 6379:6379 \
  -v ~/docker/redis-dev/module/redis.conf:/usr/local/etc/redis/redis.conf \
  -v ~/docker/redis-dev/data:/data \
  redis:6 redis-server /usr/local/etc/redis/redis.conf

# 运行容器
docker run -d --name war01 -p 9001:8080 --network=devnet --ip=172.22.0.101 -e "page.title=war01" mock-war
docker run -d --name war02 -p 9002:8080 --network=devnet --ip=172.22.0.102 -e "page.title=war02" mock-war
# 测试容器
curl localhost:9001
curl localhost:9002

# 提取配置文件
#docker run -d --name warlb -p 9000:80 nginx:1.20
#docker cp warlb:/etc/nginx/nginx.conf nginx.conf
# 删除
#docker stop warlb
#docker rm warlb
# 修改nginx.conf

# 负载均衡
docker run -d --name warlb --network=devnet --ip=172.22.0.100 -p 9000:80 -v /Users/wangzilin/docker/warlb/nginx.conf:/etc/nginx/nginx.conf nginx:1.20

```
