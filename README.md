# conferenceTrackManagement

##环境

* 开发工具:IntelliJ IDEA 14
* JDK:1.7
* Maven:4.0.0
* junit:4.12


##数据结构
* track
* session
* talk

##入口
* TalkManage
	* 读取talk_list
	* (converter)格式化数据为一个Map, key为talk主题,value为talk时长
	* 根据总时长,初始化track & session
	* (distributor) 选择指定的分配器,分配talk
	* (printer) 根据指定的格式打印输出

##单元测试
* TalkMangeTest
* 项目根目录下执行 mvn clean test

##todo
* session之间存在时间间隙,分配后需要做平衡操作
