# limits-service
Limits Service - Config Client

# spring.cloud.config.profile is for setting the profile for spring cloud config
# spring.profiles.active is for setting the profile for spring boot config like yml or properties file reference
-------------------------------------------------------------------------------------------------------------------------
Passing Profile - Approach1:

# To pass 'Java application arguments' while boot the application using gradlew , please add the following configuration
# to build.gradle and then use the following command
Configuration:
bootRun {
	if (project.hasProperty('args')) {
		args project.args.split(',')
	}
}

Command:
instance 1 : gradlew bootRun -Pargs=--server.port=8080,--RABBIT_URI=amqp://localhost,--spring.cloud.config.profile=stage,--spring.profiles.active=stage,--logging.level.org.springframework=OFF,,--eureka-server-url=http://localhost:8761/eureka,--config-server-url=http://localhost:8888


instance 2 : gradlew bootRun  -Pargs=--server.port=8081,--RABBIT_URI=amqp://localhost,--spring.cloud.config.profile=stage,--spring.profiles.active=stage,--logging.level.org.springframework=OFF,,--eureka-server-url=http://localhost:8761/eureka,--config-server-url=http://localhost:8888

Source -> Ref Link : https://www.baeldung.com/spring-boot-command-line-arguments

-------------------------------------------------------------------------------------------------------------------------

Passing Profile - Approach2:

# To pass 'JVM arguments' while boot the application using gradlew , please add the following configuration
# to build.gradle and then use the following command
Configuration:
bootRun {
	// support passing -Dsystem.property=value to bootRun task
	systemProperties = System.properties
}

Command:
instance 1 : gradlew bootRun -DRABBIT_URI=amqp://localhost -Dserver.port=8080 -Dspring.cloud.config.profile=stage -Dspring.profiles.active=stage -Deureka-server-url=http://localhost:8761/eureka -Dconfig-server-url=http://localhost:8888

instance 2 : gradlew bootRun -DRABBIT_URI=amqp://localhost -Dserver.port=8081 -Dspring.cloud.config.profile=stage -Dspring.profiles.active=stage -Deureka-server-url=http://localhost:8761/eureka -Dconfig-server-url=http://localhost:8888


Note:
If you want to register all the service instances to Rabbit MQ (Spring Cloud Bus Implementation) then
we have to run the following command for higher environments if they Rabbit MQ Message Broker is running in different machine than the host one
# The Rabbit URI will be environment specific and it has to be passed as an JVM argument
instance 1 : gradlew bootRun -DRABBIT_URI=<amqp://localhost>    
instance 2 : gradlew bootRun -DRABBIT_URI=<amqp://localhost> 

-------------------------------------------------------------------------------------------------------------------------
Passing Profile - Approach3:

Hard code the following configuration at 'bootstrap.properties'
spring.cloud.config.profile={profile} 

----------------------------------------------------------------------------------------------------------------

Note: To refresh the config server values bound to any property during the boot time , we need to refresh via actuator (post call) http://localhost:8080/actuator/refresh 
(or)
http://localhost:8080/actuator/bus-refresh 

Note: To get the 'LimitsServiceApplicationTests' passed, we have to have the 'Spring Cloud Config Server' and 'Naming Server' up and running.