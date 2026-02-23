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

    return {educationRegister: educationRegister};
})();