console.log("dark light mode")


let currentTheme =getTheme();

changeTheme();

function changeTheme() {
    document.querySelector('html').classList.add(currentTheme)

    //set leister to current theme button
    const changethemeButton = document.querySelector('#theme_change_button');
    changethemeButton.querySelector("span").textContent= currentTheme == "light" ? "Dark":"Light";
    changethemeButton.addEventListener('click',(event) =>{
        console.log("change theme");
       const oldTheme = currentTheme;
        if(currentTheme == "dark"){
            setTheme("light")
            currentTheme = "light"
        }
        else{
            setTheme("dark")
            currentTheme = "dark"
        }
        //local storage update 
        setTheme(currentTheme);
        document.querySelector('html').classList.remove(oldTheme);
        //set the current theme
        document.querySelector('html').classList.add(currentTheme);
        //change the button text 
        changethemeButton.querySelector("span").textContent= currentTheme == "light" ? "Dark":"Light";
       
    });


}
//set the theme to local storage
function setTheme(theme){
    localStorage.setItem("theme", theme);
}


//get the theme local storage
function getTheme(){
    let theme = localStorage.getItem("theme");
   if(theme){
    return theme;
   }else {
    return "light";
}
}

//change current theme