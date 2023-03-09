node {
  stage("Clone the project") {
    git branch: 'feature/backend/loginRegister', url: 'https://github.com/Chaturvedi-Animesh/Tigers-tournament-backend.git'
  }

  stage("Compilation") {
    sh "./mvn clean install -DskipTests"
  }

  stage("Tests and Deployment") {
    stage("Runing unit tests") {
      sh "./mvnw test -Punit"
    }
    stage("Deployment") {
      sh 'nohup ./mvnw spring-boot:run -Dserver.port=8082 &'
    }
  }
}