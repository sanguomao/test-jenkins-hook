@library('test-lib') _

pipeline {
    agent any

    environment {
        DOCKER_DEV_REGISTRY="https://harbor.longguikeji.com"
    }

    stages {
        stage('Build') {
            script {
                testShared 'abc'
            }
        }
    }
}
