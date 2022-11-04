
pipeline {
    
    agent any 
    environment { 
        registry = "sofiene1998/tpachat_image" 
        registryCredential = 'dockerHub' 
        dockerImage = '' 
    }
	stages{
		stage('Checkout Git'){
            steps{
                echo 'Pulling...';
                git branch: 'sofiene',
                url :'https://github.com/ShaymaRebhi/tpAchatProject-Server.git';
            }			
        }
		
		stage('MVN CLEAN'){
            steps{
                sh 'mvn clean'
            }			
        }
		
		stage('MVN COMPILE'){
            steps{
                sh 'mvn -DskipTests=true  package'
            }	
    	}
			
		stage('MVN SONARQUBE'){
            steps{
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }			
        } 
		
		stage('MVN DEPLOY NEXUS'){
            steps{
                sh 'mvn deploy -Dmaven.test.skip=true'
            }			
        } 

        stage('Building Docker Image') { 
            steps { 
                script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                }
            } 
        }
	
        stage('Push Docker Image') { 
            steps { 
                script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push() 
                    }
                } 
            }
        }
		
	}
}
