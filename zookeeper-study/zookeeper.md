##准备配置文件
cp /opt/zookeeper-3.4.9/conf/zoo_sample.cfg /opt/zookeeper-3.4.9/conf/zoo.cfg
Zookeeper要求配置文件的文件名必须是：zoo.cfg
##创建数据目录
mkdir /opt/zookeeper-3.4.9/data
##在zoo.cfg中配置数据目录的位置
dataDir=/opt/zookeeper-3.4.9/data

##常用命令
启动服务器：./zkServer.sh start
停止服务器：./zkServer.sh stop
启动客户端：./zkCli.sh  ./zkCli.sh -server locahost:port
退出客户端：[zk: localhost:2181(CONNECTED) 6] quit
