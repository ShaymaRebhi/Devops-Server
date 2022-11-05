pipeline{
agent any
  tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'
  }

        stages{


                 stage('Build Maven Spring'){
                             steps{
                                sh 'mvn  clean install '
                             }
                         }
      stage('Testing process') {
                              steps {
                               script {
                                sh 'echo "Test is processing ...."'
                                sh 'mvn clean test -DskipTests=true'
                               }
                              }
                            }
			    stage('Build docker image'){
                             steps{
                                 script{
                                    sh 'docker build -t shaymarebhi/springprojet .'
                                 }
                             }
                         }



		stage("Maven Build") {
            steps {
                script {
                    sh "mvn package -DskipTests=true"
                }
            }
        }

		 		 stage('Docker login') {

                                         steps {
                                          sh 'echo "login Docker ...."'
                   	sh 'docker login -u shaymarebhi -p lafloufet123'
                               }  }
		 stage('Docker push') {

                 steps {
                      sh 'echo "Docker is pushing ...."'
                     	sh 'docker push shaymarebhi/springprojet'
                        }  }
         stage('Docker compose') {

                          steps {
                               sh 'docker-compose up -d'
                                 }  }




//               stage('Quality Gate Status Check'){
//                   steps{
//                       script{
// 			      withSonarQubeEnv('sonar') {
// 			      sh "mvn compile sonar:sonar"
//                        	     	}
// 			      timeout(time: 1, unit: 'HOURS') {
// 			      def qg = waitForQualityGate()
// 				      if (qg.status != 'OK') {
// 					   error "Pipeline aborted due to quality gate failure: ${qg.status}"
// 				      }
//                     		}
// 		    	    sh "mvn clean install"
//                  	}
//                	 }
              }
      }