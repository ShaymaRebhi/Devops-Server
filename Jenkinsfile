pipeline {
    agent any
    tools {
    	maven 'M2_HOME'
    }
    stages {
       
        stage('Checkout GIT ') {
            steps {
                echo 'Pulliing ...';
                git branch: 'Ons', url: 'https://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@github.com/ShaymaRebhi/tpAchatProject-Server.git'            }

        }
	    
	    stage('compiler') {
      		steps {
        		sh 'mvn compile'
      		}
    	}
	    stage('Build') {
      		steps {
        		sh 'mvn -B -DskipTests clean package'
      		}
    	}
	    
        stage('Testing maven') {
		    steps {
		    sh """mvn -version"""
	        }
	    }

	     stage('Junit/Mockito') {
                                       steps {
                                       script {
                                        sh 'echo "Test is processing ...."'
                                        sh 'mvn test'
                                       }
                                      }
                                    }
	     stage('NEXUS')
        {
            steps{
                echo "nexus"
                 sh ' mvn clean deploy -DskipTests'
            }
        }
        
	    stage('MVN SONARQUBE'){
            steps{
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=NOSnos1312'
            }			
        }
        
       
}
}