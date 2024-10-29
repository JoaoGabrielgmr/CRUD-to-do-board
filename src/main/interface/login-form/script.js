// const email = document.querySelector("#email");
// const passwd = document.querySelector("#password");
// const form = document.querySelector("form");

// async function login() {
//     const url = "http://127.0.0.1:5500/cadastrar";
//     try{
//         const response = await fetch(url, {
//             method: "POST",
//             body: JSON.stringify({
//                 form: this.form.value,
//                 email: this.email.value,
//                 passwd: this.passwd.value
//             })
//         });
//         if(!response.ok){
//             console.log("post ok")
//             throw new Error(`Response Status: ${response.status}`);
//         }

//         const json = response.json;
//         console.log(json);

//     }catch(error){
//         console.error(error.message);
//     }
// }

// form.addEventListener("submit", function(event) {
//     event.preventDefault();
//     login();
    
// });
