myPageActivityService = (() => {

//     추가
    const activityRegister = async (formData) => {
        await fetch('/mypage/activity/regist', {
            method: 'POST',
            body: formData
        })
    }

    // 목록
    const getActivityList = async (memberId, callback) => {}

    return {activityRegister: activityRegister, getActivityList: getActivityList}
})();