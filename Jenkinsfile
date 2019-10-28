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

    post {
        success {
            sendDingTalk("success", "构建成功")
        }
        failure {
            sendDingTalk("failure", "构建失败")
        }
    }
}
