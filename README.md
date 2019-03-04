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
gradlew bootRun -Pargs=--name=Mike,--spring.cloud.config.profile=stage,--spring.profiles.active=stage

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
gradlew bootRun -Dname=Mike -Dspring.cloud.config.profile=stage -Dspring.profiles.active=stage

-------------------------------------------------------------------------------------------------------------------------
Passing Profile - Approach3:

Hard code the following configuration at 'bootstrap.properties'
spring.cloud.config.profile={profile} 
----------------------------------------------------------------------------------------------------------------

Note: To refresh the config server values bound to any property during the boot time , we need to refresh via actuator (post call) http://localhost:8080/actuator/refresh 


Note: To get the 'LimitsServiceApplicationTests' passed, we have to have the Spring Cloud Config Server up and running.