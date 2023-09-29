import { Component, OnInit } from '@angular/core';
import { Book } from './book';
import { BookService } from './book.service';
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { NONE_TYPE } from '@angular/compiler';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public books : Book[];
  public deleteBook: Book;
  public updateBook: Book;

  constructor(private bookService:BookService) { }
  
  ngOnInit(): void {
    this.getBooks();
  }

  public getBooks(): void{
    this.bookService.getBooks().subscribe(
      (response : Book[]) => {
        this.books = response;
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
        
    )
  }
  
  public onAddBook(addForm: NgForm) :void{

    document.getElementById('close-button-add').click();
    

     this.bookService.addBook(addForm.value).subscribe(
      (response: Book) =>{
        console.log(response);
        this.getBooks();
      },
      (error: HttpErrorResponse) =>
      {
        console.log(error.message);
      }
    )
  }

  public onDeleteBook(bookId: number) :void{

    document.getElementById('close-button-delete').click();

    this.bookService.deleteBook(bookId).subscribe(
      (response: void) =>{
        console.log(response);
        this.getBooks();
      },
      (error: HttpErrorResponse) =>
      {
        console.log(error.message);
      }
    )
  }

  public onUpdateBook(book: Book) :void{

    document.getElementById('close-button-update').click();

    this.bookService.updateBook(book).subscribe(
      (response: Book) =>{
        console.log(response);
        this.getBooks();
      },
      (error: HttpErrorResponse) =>
      {
        console.log(error.message);
      }
    )
  }

  public onOpenModal(book: Book, mode: string): void{

    

    

    if(mode === 'add'){
      
    }

    if(mode === 'delete'){
      this.deleteBook = book;
      
    }

    if(mode === 'update'){
      this.updateBook = book;
    }

    
  }
}
