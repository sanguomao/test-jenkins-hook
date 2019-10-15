void setBuildStatus(String message, String state) {
  step([
      $class: "GitHubCommitStatusSetter",
      reposSource: [$class: "ManuallyEnteredRepositorySource", url: "https://github.com/sanguomao/test-jenkins-hook"],
      contextSource: [$class: "ManuallyEnteredCommitContextSource", context: "sanguomao-commit-status"],
      errorHandlers: [[$class: "ChangingBuildStatusErrorHandler", result: "UNSTABLE"]],
      statusResultSource: [ $class: "ConditionalStatusResultSource", results: [[$class: "AnyBuildResult", message: message, state: state]] ]
  ]);
}
//转义字符比较多，复制粘贴有可能出问题，请自行解决
void SendDingding(res)
{
  //钉钉机器人的地址，暂时不用修改
  dingding_url="https://oapi.dingtalk.com/robot/send\\?access_token\\=dd5c1cb2126de9752de4a7aa36264262cfdeeb2d56e7def0f4e96b6d5f85b8a8"
  //输入相应的手机号码，才能在钉钉群指定通知某个人
  tel_num="18210242928"
  post_header="Content-Type:application/json;charset=utf-8"
  if( res == "success" )
  {
    json_msg='{\\"msgtype\\":\\"text\\",\\"text\\":{\\"content\\":\\"@' + tel_num +' 恭喜你，' + "${env.BUILD_URL} ${env.JOB_NAME} 第${env.BUILD_NUMBER} 次"  + '构建成功 \\"},\\"at\\":{\\"atMobiles\\":[\\"' + tel_num + '\\"],\\"isAtAll\\":false}}'
    sh_cmd="curl -X POST " + dingding_url + " -H " + "\'" + post_header + "\'" + " -d " + "\""  + json_msg + "\""
    sh sh_cmd
  }
  else
  {
    json_msg='{\\"msgtype\\":\\"text\\",\\"text\\":{\\"content\\":\\"@' + tel_num +' 完蛋了！！！' + "${env.JOB_NAME} 第${env.BUILD_NUMBER} 次"  + '构建出问题了 \\"},\\"at\\":{\\"atMobiles\\":[\\"' + tel_num + '\\"],\\"isAtAll\\":false}}'
    sh_cmd="curl -X POST " + dingding_url + " -H " + "\'" + post_header + "\'" + " -d " + "\""  + json_msg + "\""
    sh sh_cmd
  }
}

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'exit 0'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
    post {
        success {
            setBuildStatus("sanguomao Build succeeded", "SUCCESS");
            SendDingding("success")
        }
        failure {
            setBuildStatus("sanguomao Build failed", "FAILURE");
            SendDingding("failure")
        }
    }
}
