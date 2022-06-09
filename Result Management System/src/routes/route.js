const express = require('express')
const route = express.Router()

const mysql = require('mysql2');
const pool = mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: 'root',
    database: 'resultmanagement'
});

route.get('/', async (req, res) => {
    res.render('index', { logout: 'false', back: 'index' })


})

route.get('/studentLogin', async (req, res) => {
    res.render('studentLogin', { logout: 'false', back: 'studentLogin' ,wrongcredential:'false'})

})

route.post('/studentLogin', async (req, res) => {


    pool.getConnection((err, connection) => {
        if (err) throw err;
        console.log('connected as id ' + connection.threadId);
        let selectQuery = 'SELECT * FROM student WHERE name=? AND rollno=?';
        let query = mysql.format(selectQuery, [req.body.name, req.body.rollno]);
        // query = SELECT * FROM `todo` where `user` = 'shahid'
        pool.query(query, (err, data) => {
            if (err) {
                console.error(err);
                return;

            }
            // rows fetch
            console.log(data);
            if (data.length > 0)
                res.render('viewResult', { logout: 'true', back: 'viewResult', studentdata: data })
            else
                res.render('studentLogin', { logout: 'false', back: 'studentLogin',wrongcredential:'true' })
                
        });
    });

})

route.get('/teacherLogin', async (req, res) => {
    res.render('teacherLogin', { logout: 'false', back: 'teacherLogin',wrongcredential:'false' })


})

route.post('/teacherLogin', async (req, res) => {

    pool.getConnection((err, connection) => {
        if (err) throw err;
        console.log('connected as id ' + connection.threadId);
        let selectQuery = 'SELECT * FROM teacher WHERE uname=? AND pass=?';
        let query = mysql.format(selectQuery, [req.body.name, req.body.pass]);
        // query = SELECT * FROM `todo` where `user` = 'shahid'
        pool.query(query, (err, data) => {
            if (err) {
                console.error(err);
                return;
            }
            // rows fetch
            console.log(data);
            if (data.length > 0)
                res.redirect('/viewall');
            else
                res.render('teacherLogin', { logout: 'false', back: 'studentLogin',wrongcredential:'true'})
        });
    });

})

route.get('/addStudent', async (req, res) => {
    res.render('addStudent', { logout: 'true', back: 'addStudent' })

})

route.post('/addStudent', async (req, res) => {

    pool.getConnection((err, connection) => {
        if (err) throw err;
        console.log('connected as id ' + connection.threadId);
        let selectQuery = 'SELECT * FROM student WHERE rollno=?'
        let query = mysql.format(selectQuery, [req.body.rollno]);
        pool.query(query, (err, data) => {
            if (err) {
                console.error(err);
                return;
            }
            // rows fetch
            console.log(data);
            if (data.length > 0)
                res.redirect('/addstudent');
            else {
                let insertQuery = 'INSERT INTO student (rollno,name,dob,score) VALUES (?,?,?,?)';
                let Query = mysql.format(insertQuery, [req.body.rollno, req.body.name, req.body.dob, req.body.score]);
                pool.query(Query, (err, data) => {
                    if (err) {
                        console.error(err);
                        return;

                    }
                    res.redirect('/viewall');

                })
            }
        })
    })

})

route.get('/edit/:rollno', async (req, res) => {

    pool.getConnection((err, connection) => {
        if (err) throw err;
        console.log('connected as id ' + connection.threadId);
        let selectQuery = 'SELECT * FROM student WHERE rollno=?';
        let query = mysql.format(selectQuery, [req.params.rollno]);
        // query = SELECT * FROM `todo` where `user` = 'shahid'
        pool.query(query, (err, data) => {
            if (err) {
                console.error(err);
                return;
            }
            // rows fetch
            console.log(data);
            if (data.length > 0)
                res.render('editstudent', { logout: 'true', back: 'edit', studentdata: data })

        });
    });

})

route.post('/editstudent', async (req, res) => {

    let updateQuery = "UPDATE student SET name = ? , dob=? ,score=? WHERE rollno = ?";
    let query = mysql.format(updateQuery, [req.body.name, req.body.dob, req.body.score, req.body.rollno]);
    // query = UPDATE 
    pool.query(query, (err, response) => {
        if (err) {
            console.error(err);
            return;
        }
        // rows updated
        console.log(response.affectedRows);
    });
    res.redirect('/viewall');

})



route.get('/viewall', async (req, res) => {



    pool.getConnection((err, connection) => {
        if (err) throw err;
        console.log('connected as id ' + connection.threadId);
        let selectQuery = 'SELECT * FROM student';
        pool.query(selectQuery, (err, data) => {
            if (err) {
                console.error(err);
                return;
            }
            // rows fetch
            console.log(data);
            res.render('viewall', { logout: 'true', back: 'viewall', studentdata: data })

        });
    });

})



route.get('/viewResult', async (req, res) => {
    res.render('viewResult', { logout: 'true', back: 'viewResult' })


})

route.get('/delete/:rollno', async (req, res) => {

    pool.getConnection((err, connection) => {
        if (err) throw err;
        console.log('connected as id ' + connection.threadId);
        let selectQuery = 'DELETE FROM student WHERE rollno=?';
        let query = mysql.format(selectQuery, [req.params.rollno]);
        // query = SELECT * FROM `todo` where `user` = 'shahid'
        pool.query(query, (err, data) => {
            if (err) {
                console.error(err);
                return;
            }
            // rows fetch
            console.log(data);
            res.redirect('/viewall')

        });
    });

})


module.exports = route