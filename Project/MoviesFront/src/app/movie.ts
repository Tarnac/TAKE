import { Category } from "./category";

export class Movie{
    id: number;
    title: string;
    category: Category;
    year: string;
    plot: string;
    price: number;

    constructor(id: number, title: string, category: Category, year: string,plot: string, price: number){
        this.id = id;
        this.title = title;
        this.category = category;
        this.year = year;
        this.plot = plot
        this.price = price;
    }
}