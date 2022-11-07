pipeline{
agent any
  tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'
  }

   stages{
         stage('Cleaning') {
                                      steps {
                                       script {
                                        echo 'cleaning';
                                        sh 'mvn clean '
                                       }
                                      }
                                    }

 stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
            }
        }
 stage('MVN SONARQUBE ') {
                                                                           steps{
                                                                              sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar  '
                                                                             }
                                                                            }

stage('JUNIT/MOCKITO') {
                                      steps {
                                       script {
                                        echo 'testing';
                                        sh 'mvn test'
                                       }
                                      }
                                    }

          stage('NEXUS')    {
                                  steps{
                                   echo "nexus"
                                    sh ' mvn  deploy -DskipTests'
                                     }
                                   }

         // stage("Maven Build") {
             //                                steps {
                  //                               script {
                   //                               sh "mvn package -DskipTests=true"
                   //                                       }
                   //                                  }
                   //                      }



         stage('Build docker image'){
                                     steps{
                                         script{
                                            sh 'docker build -t oumaymafarhani/springprojet .'
                                                 }
                                         }
                                    }



        stage('Docker login') {

                                   steps {
                                    sh 'echo "login Docker ...."'
                                    sh 'docker login -u oumaymafarhani -p 29416927Oumayma'
                                       }
                                }
         stage('Docker push') {
                               steps {
                                  sh 'echo "Docker is pushing ...."'
                                sh 'docker push oumaymafarhani/springprojet'
                                }
                               }
        stage('Docker compose') {
                                steps {
                                  sh 'docker-compose up -d'
                                       }
                                   }

s
                }

      }
