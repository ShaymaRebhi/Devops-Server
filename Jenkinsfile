pipeline{
agent any
	stage('Compile Maven Project'){
                                                             steps{
                                                                sh 'mvn  compile '
                                                             }
                                                         }
        stages{
 stage('Mock & JUnit') {
 steps {
script {
sh 'echo "Mock & JUnit"'
sh 'mvn test'
 }
 }
 post {
  always {
junit '**/target/surefire-reports/TEST-*.xml'
   }
  }
 }
    stage('MVN SONARQUBE ')
              {
     steps{
 sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar  '
  }
    }

  stage('Build Maven Spring'){
  steps{
 sh 'mvn  clean install '
   }
  }

  stage('NEXUS')
 {
  steps{
        echo "nexus"
       sh ' mvn deploy -DskipTests'
         }
       }

 stage('Build docker image'){
 steps{
 script{
 sh 'docker build -t hibaef/springprojet .'
 }
 }
 }

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
  }  } }
post {
 success {
	 mail to: "hiba.elwafi@esprit.tn",
	subject: "Pipeline Backend Success ",
 	body: "Welcome to DevOps project Backend : Success on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL}"
}
	failure {
          mail to: "hiba.elwafi@esprit.tn",
           subject: "Pipeline backend Failure",
           body: "Welcome to DevOps project Backend : Failure on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL} "
                    }
                    }
      }
