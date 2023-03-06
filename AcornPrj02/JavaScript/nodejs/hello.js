const readline = require('readline');
const { RSA_X931_PADDING } = require('constants');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

rl.question("당신의 이름은 : ", name => {
    console.log(`당신의 이름은 ${name}이군요.`);
});




