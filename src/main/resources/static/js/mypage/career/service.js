const myPageService = (() => {

//     추가
    const careerRegister = async (career) => {
        await fetch('/mypage/career/regist', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(career)
        })
    }

    // 목록
    const getCareerList = async (memberId, callback) => {
        const response = await fetch(`/mypage/${memberId}`);
        const data = await response.json();
        if(callback){
            callback(data);
        }
    }

    // 삭제
    const deleteCareer = async (careerId) => {
        await fetch(`/mypage/${careerId}`, {method: 'DELETE'});
    }

    return {careerRegister: careerRegister, getCareerList: getCareerList, deleteCareer: deleteCareer};
})();
