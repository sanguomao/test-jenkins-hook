def info(message) {
    echo "INFO: ${message}"
}

def warning(message) {
    echo "WARNING: ${message}"
		println(this.env.DOCKER_DEV_REGISTRY)
}

def sendDingTalk(status, message) {
    if (status == "success") {
        img="https://s2.ax1x.com/2019/10/17/KEFSWd.png"
    } else if (status == "failure") {
        img="https://s2.ax1x.com/2019/10/17/KEFCQI.png"
    } else if (status == "pending") {
        img="https://s2.ax1x.com/2019/10/17/KEFkef.gif"
    } else {
        img=""
    }
    dingTalk([
        accessToken: "${env.DING_TALK_ENTRYPOINT}",
        jenkinsUrl: "${env.JENKINS_URL}",
        imageUrl: img,
        message: message,
    ])
}
