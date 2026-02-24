const modalTabbtns = document.querySelectorAll(".modal-sidebar .tab-container");
const changeModalBtns = document.querySelectorAll(".modal-detail .change");
// const modalTabbtn = () => {
    
// }

// 마이페이지 LNB영역 버튼 이벤트
modalTabbtns.forEach(modalTabbtn => {
    modalTabbtn.addEventListener("click", (e) => {
        modalTabbtns.forEach(modalTabbtn => modalTabbtn.classList.remove("active"));
        modalTabbtn.classList.add("active");
    })
    modalTabbtn.addEventListener("mousedown", (e) => {
        modalTabbtn.classList.add("down");
    })
    modalTabbtn.addEventListener("mouseup", (e) => {
        modalTabbtn.classList.remove("down");
    })
    modalTabbtn.addEventListener("mouseout", (e) => {
        modalTabbtn.classList.remove("down");
    })
    
})

changeModalBtns.forEach(changeModalBtn => {
    changeModalBtn.addEventListener("click", (e) => {
        const forms = document.querySelectorAll("#form-modal .form-group");
        const _this = e.currentTarget.id.replace("Change", "");
        const _thisForm = document.getElementById(_this+"Form");
        forms.forEach(form => {
            form.classList.add("none");
        })
        _thisForm.classList.remove("none")
    })
})

//===============================================경력 등록==========================================================

const registerBtn = document.getElementById("save-career-btn");
const affilationTitle = document.getElementById("career-company");
const careerType = document.getElementById("career-type");
const startYear = document.getElementById("career-start-year");
const endYear = document.getElementById("career-end-year");
const startMonth = document.getElementById("career-start-month");
const endMonth = document.getElementById("career-end-month");
const careerSkill = document.getElementById("career-skills");
const careerRole = document.getElementById("career-role");
const careerDescription = document.getElementById("career-desc");
let memberId = null;
const memberIdInput = document.getElementById("member-id");
const closeCareerModal = document.getElementById("career-modal");
const modalInput = document.querySelectorAll(".modal-container");
const careerContainer = document.querySelector('.user-content-history-content-wrap');


if(memberIdInput){
    memberId = memberIdInput.value;
}


myPageService.getCareerList(memberId, myPageLayout.showList);
myPageEducationService.getEducationList(memberId, educationLayout.showList);

registerBtn.addEventListener("click", async (e) => {
    await myPageService.careerRegister(
        {
            affiliationTitle : affilationTitle.value,
            memberEmploymentType : careerType.value,
            startYear : startYear.value,
            endYear : endYear.value,
            startMonth : startMonth.value,
            endMonth : endMonth.value,
            memberSkill : careerSkill.value,
            memberRole : careerRole.value,
            introDetailed : careerDescription.value,
            memberId : memberId
        });
    await myPageService.getCareerList(memberId, myPageLayout.showList);

    modalInput.forEach(modal => {
        modal.querySelectorAll("input, textarea").forEach(el => el.value = "");
        modal.querySelectorAll("select").forEach(el => el.selectedIndex = 0);

        closeCareerModal.style.display = "none";
    });
})


careerContainer.addEventListener("click", async (e) => {
    e.preventDefault();
    const careerId = e.target.dataset.id;

    if(e.target.classList.contains("career-delete-btn")){
        await myPageService.deleteCareer(careerId);
        await myPageService.getCareerList(memberId, myPageLayout.showList);
    }
})

// ================================================학력 등록=======================================================
const educationTitle = document.getElementById("edu-school");
const educationType = document.getElementById("edu-type");
const educationMajor = document.getElementById("edu-major");
const educationGraduation = document.getElementById("edu-status");
const eduIntro = document.getElementById("edu-desc");
const eduStartYear = document.getElementById("edu-start-year");
const eduEndYear = document.getElementById("edu-end-year");
const eduStartMonth = document.getElementById("edu-start-month");
const eduEndMonth = document.getElementById("edu-end-month");
const eduRegisterBtn = document.getElementById("save-edu-btn");
const closeEduModal = document.getElementById("education-modal");
const eduContainer = document.querySelector('.user-content-education-content-wrap');



eduRegisterBtn.addEventListener("click", async (e) => {
    await myPageEducationService.educationRegister({
        educationTitle : educationTitle.value,
        educationType : educationType.value,
        educationMajor : educationMajor.value,
        educationGraduation : educationGraduation.value,
        introDetailed : eduIntro.value,
        startYear : eduStartYear.value,
        endYear : eduEndYear.value,
        startMonth : eduStartMonth.value,
        endMonth : eduEndMonth.value,
        memberId : memberId
    })
    await myPageEducationService.getEducationList(memberId, educationLayout.showList)


    modalInput.forEach(modal => {
        modal.querySelectorAll("input, textarea").forEach(el => el.value = "");
        modal.querySelectorAll("select").forEach(el => el.selectedIndex = 0);

        closeEduModal.style.display = "none";
    });
})

eduContainer.addEventListener("click", async (e) => {
    e.preventDefault();
    const educationId = e.target.dataset.id;

    if(e.target.classList.contains("education-delete-btn")){
        await myPageEducationService.deleteEducation(educationId)
        await myPageEducationService.getEducationList(memberId, educationLayout.showList);
    }
})

// =================================활동 내역 등록===========================================================

const activityTitle = document.getElementById("activity-title");
const activityType = document.getElementById("activity-type");
const actStartYear = document.getElementById("activity-start-year");
const actStartMonth = document.getElementById("activity-start-month");
const activityFile = document.getElementById("activity-skills");
const activityRegisterBtn = document.getElementById("save-activity-btn");
const activityModal = document.getElementById("setting-modal");

activityRegisterBtn.addEventListener("click", async (e) => {
    e.preventDefault();
    const formData = new FormData();
    // 일반데이터 추가
    formData.append("awardTitle", activityTitle.value);
    formData.append("activityType", activityType.value);
    formData.append("activityStartYear", actStartYear.value);
    formData.append("activityStartMonth", actStartMonth.value);
    formData.append("memberId", memberId);

    FileList.prototype.forEach = Array.prototype.forEach;

    // 다중 파일 추가
    const files = activityFile.files;
    files.forEach((file) => {
        file.addEventListener("change", (e) => {
            e.target.files.forEach((file) => {
                if(file.size / 1024 / 1024 > 10){
                    return alert("파일이 너무 큽니다.");
                }
            })
        })
    })
    for(let i = 0; i < files.length; i++){
        formData.append("file", files[i]);
    }

    await myPageActivityService.activityRegister(formData);

    modalInput.forEach(modal => {
        modal.querySelectorAll("input, textarea").forEach(el => el.value = "");
        modal.querySelectorAll("select").forEach(el => el.selectedIndex = 0);

        activityModal.style.display = "none";
    });
})




















