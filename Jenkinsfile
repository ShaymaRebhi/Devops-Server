pipeline{
agent any
  tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'
  }

        stages{




 stage('Testing process') {
                              steps {
                               script {
                                sh 'echo "Test is processing ...."'
                                sh 'mvn clean test'
                               }
                              }
                            }
/*    stage('MVN SONARQUBE ')
              {
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

			    stage('Build docker image'){
                             steps{
                                 script{
                                    sh 'docker build -t sofiene1998/springprojet .'
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
                   	sh 'docker login -u sofiene1998 -p leoncupra1'
                               }  }
		 stage('Docker push') {

                 steps {
                      sh 'echo "Docker is pushing ...."'
                     	sh 'docker push sofiene1998/springprojet'
                        }  }
         stage('Docker compose') {

                          steps {
                               sh 'docker-compose up -d'
                                 }  }

        }

      }
