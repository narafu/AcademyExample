
function f1(a, b, c) {
    console.log(`kor:${this.kor}, a:${a}, b:${b}`);
}

f1.call(1, 2, 3);
f1.call(1, { a: 2 });

let f3 = f1;
f3();
let f4 = f1.bind(1, 2, 3);
f4();


