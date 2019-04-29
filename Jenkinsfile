pipeline {
    agent any
    stages{
        stage('Build'){
            steps{
                bat "gradle clean"
            }
        }
        stage('Test'){
            steps{
                bat "gradle test"
            }
        }
        stage('Deploy'){
            steps{
                bat "gradle package"
	
	publishHTML target: [
            allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: 'target/surefire-reports',
            reportFiles: 'ExtentReportsTestNG.html',
            reportName: 'ExtentReport'
          ]
            }
        }
    }
}
