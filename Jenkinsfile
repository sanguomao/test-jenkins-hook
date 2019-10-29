@Library('test-lib') _

pipeline {
    agent any

    parameters {
        string(name: "PROD_VERSION", description: "the tag of the image,src to release, like `1.2.3`")
    }

    environment {
        DOCKER_DEV_REGISTRY="https://harbor.longguikeji.com"
    }

    stages {
        stage('Build') {
            steps {
                script {
                    testShared.info 'hello'
                    testShared.warning 'world'
                    testShared.getRepoName()
                }
            }
        }
    }

    post {
        success {
            script {
                testShared.sendDingTalk("success", "构建成功")
            }
        }
        failure {
            script {
                testShared.sendDingTalk("failure", "构建失败")
            }
        }
    }
}

// testShared('status')