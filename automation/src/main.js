

function hey() {
    print("${new java.util.Date()}");
    print('hello world');
    $EXEC("ls -al");
    var output = $OUT;
    print(output);
}

hey();