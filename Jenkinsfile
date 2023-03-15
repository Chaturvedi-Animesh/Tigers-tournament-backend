node {
  stage("Clone the project") {
    git branch: 'feature/backend/loginRegister', url: 'https://github.com/Chaturvedi-Animesh/Tigers-tournament-backend.git'
  }

  stage("Compilation") {
    sh "mvn clean install -DskipTests"
  }

  stage("Building") {
    stage("Building") {
      sh "mvn compile"
      sh 'mvn package'
    }
    stage("Deployment") {
      sh 'nohup java -jar target/tigerstournament-0.0.1-SNAPSHOT.jar &'
    }
  }
}