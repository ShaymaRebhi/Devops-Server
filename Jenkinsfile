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

stage('JUNIT/MOCKITO') {
                                      steps {
                                       script {
                                        echo 'testing';
                                        sh 'mvn test'
                                       }
                                      }
                                    }
/*
          stage('MVN SONARQUBE ') {
                                  steps{
                                     sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar  '
                                    }
                                   }
*/
         stage('Build Maven Spring'){
                                  steps{
                                     sh 'mvn  clean install '
                                    }
                                   }
          stage('NEXUS')    {
                                  steps{
                                   echo "nexus"
                                    sh ' mvn  deploy -DskipTests=true'
                                     }
                                   }

          stage("Maven Build") {
                                             steps {
                                                 script {
                                                  sh "mvn package -DskipTests=true"
                                                          }
                                                     }
                                         }

         stage('Build docker image'){
                                     steps{
                                         script{
                                            sh 'docker build -t sofiene1998/springprojet .'
                                                 }
                                         }
                                    }



        stage('Docker login') {

                                   steps {
                                    sh 'echo "login Docker ...."'
                                    sh 'docker login -u sofiene1998 -p leoncupra1'
                                       }
                                }
         stage('Docker push') {
                               steps {
                                  sh 'echo "Docker is pushing ...."'
                                sh 'docker push sofiene1998/springprojet'
                                }
                               }
        stage('Docker compose') {
                                steps {
                                  sh 'docker-compose up -d'
                                       }
                                   }
         stage('Sending Email') {
        always {
            emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
        }
    }

                }

      }
