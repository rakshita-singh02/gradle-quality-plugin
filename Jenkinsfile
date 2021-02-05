 pipeline {
     
  agent {
    kubernetes {
      label 'SpringBootRestApp'
      defaultContainer 'jnlp'
      yaml """
apiVersion: v1
kind: Pod
metadata:
labels:
  component: ci
spec:
  containers:
  - name: gradle
    image: gradle:3.5-jdk8-alpine
    command:
    - cat
    tty: true
"""
}
	}
  
    stages {
			
			stage('Unit Test') {
				steps {
					container('gradle') {
						
								echo 'I am executing unit test'
								sh '''
								chmod 777 *
								
								
						 
								./gradlew --no-daemon clean
								./gradlew --no-daemon build
								
							
								'''
								
							}
						}
					} 
					
		
			
		
		
	
	
	
}
}
