
pipeline {
	agent any 
	stages{
		stage('Checkout Git'){
            steps{
                echo 'Pulling...';
                git branch: 'main',
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
                sh 'mvn compile'
            }	
    	}
		 stage('Lancer les tests unitaires'){
            steps{
            echo 'Tests unitaires'
            sh "mvn test"
            }
        }
			
		stage('MVN SONARQUBE'){
            steps{
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }			
        }
	}
}