myPageActivityService = (() => {

//     추가
    const activityRegister = async (formData) => {
        await fetch('/mypage/activity/regist', {
            method: 'POST',
            body: formData
        })
    }

    // 목록
    const getActivityList = async (memberId, callback) => {
        console.log("memberId",memberId);
        // console.log("memberActivityId",memberActivityId);
        try{
            const response = await fetch(`/mypage/activity/${memberId}`);
            const data = await response.json();
            console.log("받은 데이터,,,,,,,,,,,,,",data);
            if(callback){
                callback(data);
            }
        } catch (e) {
            console.log("조회에러", e);
        }


    }

    const activityRemove = async (activityId) => {
        await fetch(`/mypage/activity/${activityId}`, {
            method: 'DELETE'});
    }

    return {activityRegister: activityRegister, getActivityList: getActivityList, activityRemove: activityRemove}
})();