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
    	stage('EMAIL ALERT') {
                steps{
                   emailext body: 'your pipeline was successfully built !everything is so good  ', subject: 'build done', to: 'ons.chebbi@esprit.tn'
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

       stage('Build docker image'){
                                    steps{
                                        script{
                                           sh 'docker build -t onschebbi/springproject .'
                                        }
                                    }
                                }

         stage('Docker Image Push ') {
                    steps {
                    script {
        		    sh 'docker login -u onschebbi -p NOSnos1312'
        		    sh 'docker push onschebbi/springproject'
        		    }
        		    }
        		    }
          stage('Docker compose') {

                                   steps {
                                        sh 'docker-compose up -d '
                                          }  }

}
}