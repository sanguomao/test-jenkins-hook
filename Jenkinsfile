@Library('test-lib') _

pipeline {
    agent any

    environment {
        DOCKER_DEV_REGISTRY="https://harbor.longguikeji.com"
    }

    stages {
        stage('Build') {
            steps {
                script {
                    testShared.info 'hello'
                    testShared.warning 'world'
                }
                testShared.info 'try'
            }
        }
    }
}
