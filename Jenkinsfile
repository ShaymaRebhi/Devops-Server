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

          stage('MVN SONARQUBE ') {
                                  steps{
                                     sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar  '
                                    }
                                   }

         stage('Build Maven Spring'){
                                  steps{
                                     sh 'mvn install '
                                    }
                                   }
          stage('NEXUS')    {
                                  steps{
                                   echo "nexus"
                                    sh ' mvn  deploy -DskipTests=true'
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

                }
post {
        success {
         mail to: "sofiene.mokaddem@esprit.tn",
         subject: "Pipeline Success",
         body: "success on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL}"
        }
        failure {
         mail to: "sofiene.mokaddem@esprit.tn",
         subject: "Pipeline failed",
         body: "failed on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL}"
        }
    }

      }
