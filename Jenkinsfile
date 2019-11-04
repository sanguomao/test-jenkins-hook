@Library('test-lib') _

pipeline {
    agent any

    stages {
        stage('ci'){
            steps{
                script {
                    testShared.info()
                }
            }
        }
    }

}


