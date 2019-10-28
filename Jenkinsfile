@Library('test-lib') _

// pipeline {
//     agent any

//     environment {
//         DOCKER_DEV_REGISTRY="https://harbor.longguikeji.com"
//     }

//     stages {
//         stage('Build') {
//             steps {
//                 script {
//                     testShared.info 'hello'
//                     testShared.warning 'world'
//                 }
//             }
//         }
//     }

//     post {
//         success {
//             script {
//                 testShared.sendDingTalk("success", "构建成功")
//             }
//         }
//         failure {
//             script {
//                 testShared.sendDingTalk("failure", "构建失败")
//             }
//         }
//     }
// }

testShared('abc')