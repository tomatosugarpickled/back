const myPageEducationService = (() => {

//     추가
    const educationRegister = async (education) => {
        await fetch('/mypage/education/regist', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(education)
        })
    }

    // 목록
    const getEducationList = async (memberId, callback) => {
        const response = await fetch(`/mypage/education/${memberId}`);
        const data = await response.json();
        if(callback){
            callback(data);
        }
    }

    // 삭제
    const deleteEducation = async (educationId) => {
        await fetch(`/mypage/education/${educationId}`, {method: 'DELETE'});
    }

    return {educationRegister: educationRegister, getEducationList: getEducationList, deleteEducation: deleteEducation};
})();