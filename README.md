# limits-service
Limits Service - Config Client

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
gradlew bootRun -Pargs=--name=Mike,--spring.cloud.config.profile=stage

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
gradlew bootRun -Dname=Mike -Dspring.cloud.config.profile=stage

-------------------------------------------------------------------------------------------------------------------------
Passing Profile - Approach3:

Hard code the following configuration at 'bootstrap.properties'
spring.cloud.config.profile={profile} 