pipeline{
agent any
 

        stages{


             stage('MVN CLEAN')
                        {
                            steps{
                            sh  'mvn clean  -DskipTests=true'
                            }
                        }
                        stage('MVN COMPILE ')
                        {
                            steps{
                            sh  'mvn compile  -DskipTests=true'
                            }
                        }
                        stage('MVN PACKAGE'){
                                      steps{
                                          sh  'mvn package  -DskipTests=true'
                                      }
                                }
                                      stage('MVN Test'){
 //                                                //         steps{
 //                                                             sh  'mvn test '
//
//                                                   }
 //                                      }
                                        stage('MVN SONARQUBE ')                                                         {
                                                            steps{
                                                             sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar  -DskipTests=true'
                                                             }
                                                         }
                                        //  stage("nexus deploy"){
//                                                    steps{
//                                                      sh 'mvn  deploy  -DskipTests=true'
//                                                                      }
//                                                                   }
			    stage('Build docker image'){
                             steps{
                                 script{
                                    sh 'docker build -t hibaef/springprojet .'
                                 }
                             }
                         }



// 		stage("Maven Build") {
//             steps {
//                 script {
//                     sh "mvn package -DskipTests=true"
//                 }
//             }
//         }

		 		 stage('Docker login') {

                                         steps {
                                          sh 'echo "login Docker ...."'
                   	sh 'docker login -u hibaef -p 13632307Hiba'
                               }  }
		 stage('Docker push') {

                 steps {
                      sh 'echo "Docker is pushing ...."'
                     	sh 'docker push hibaef/springprojet'
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
